package com.github.tacetfive.ironmiller.core.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.toImmutableList
import ru.gitverse.olimp.rickandmortyapp.R
import ru.gitverse.olimp.rickandmortyapp.core.domain.models.Character
import ru.gitverse.olimp.rickandmortyapp.core.domain.models.Character.Gender
import ru.gitverse.olimp.rickandmortyapp.core.domain.models.Character.Status
import ru.gitverse.olimp.rickandmortyapp.core.ui.compoments.ModelSearchBar
import ru.gitverse.olimp.rickandmortyapp.core.ui.screens.InitialLoadingScreen
import ru.gitverse.olimp.rickandmortyapp.core.ui.theme.RickAndMortyTheme
import ru.gitverse.olimp.rickandmortyapp.core.ui.utils.errorMessage
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.items.CharacterItem
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.state.list.CharacterListUiEvent
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.state.list.CharacterListUiSideEffect
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.state.list.CharacterListUiState
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.viewmodels.CharacterListViewModel
import ru.gitverse.olimp.rickandmortyapp.features.characters.ui.views.CharacterList

@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel,
    onCharacterClick: (CharacterItem) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    val resources = LocalResources.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is CharacterListUiSideEffect.ShowError -> {
                    snackbarHostState.showSnackbar(
                        message = effect.error.errorMessage(resources)
                    )
                }
            }
        }
    }

    CharacterListScreenContent(
        state = state,
        snackbarHostState = snackbarHostState,
        onCharacterClick = onCharacterClick,
        onReload = { viewModel.handleEvent(CharacterListUiEvent.Reload) }
    )
}

@Composable
private fun CharacterListScreenContent(
    state: CharacterListUiState,
    snackbarHostState: SnackbarHostState? = null,
    onCharacterClick: (CharacterItem) -> Unit = {},
    onReload: () -> Unit = {}
) {
    val query = rememberTextFieldState(state.query)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ModelSearchBar(
                query,
                hint = stringResource(R.string.hint_search_character),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = RickAndMortyTheme.dimens.spacingM,
                        vertical = RickAndMortyTheme.dimens.spacingXs
                    ),
            )
        },
        snackbarHost = {
            snackbarHostState?.let { SnackbarHost(it) }
        },
        contentWindowInsets = WindowInsets()
    ) { innerPadding ->

        if (state.characters.isEmpty()) {
            InitialLoadingScreen(
                showLoading = state.isLoading,
                showError = state.shouldShowError,
                onReload = onReload,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        } else {
            PullToRefreshBox(
                isRefreshing = state.isLoading,
                onRefresh = onReload,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CharacterList(
                    characters = state.characters,
                    onItemClick = onCharacterClick,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun CharacterListScreenPreview(
    @PreviewParameter(CharacterListStatePreviewProvider::class) state: CharacterListUiState
) {
    RickAndMortyTheme {
        CharacterListScreenContent(
            state = state
        )
    }
}

private class CharacterListStatePreviewProvider : PreviewParameterProvider<CharacterListUiState> {
    companion object {
        val characters = List(10) {
            CharacterItem(
                id = it + 1,
                name = "Character ${it + 1}",
                status = Status.entries[it % Status.entries.size],
                species = "Human",
                gender = Gender.entries[it % Gender.entries.size],
                lastLocation = Character.Location(it + 1, "Location ${it + 1}")
            )
        }.toImmutableList()
    }

    override val values: Sequence<CharacterListUiState>
        get() = sequenceOf(
            CharacterListUiState(isLoading = true),
            CharacterListUiState(shouldShowError = true),
            CharacterListUiState(isLoading = true, characters = characters),
            CharacterListUiState(characters = characters),
        )
}