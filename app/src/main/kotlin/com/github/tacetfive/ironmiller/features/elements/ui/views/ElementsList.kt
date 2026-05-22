package com.github.tacetfive.ironmiller.features.elements.ui.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.tacetfive.ironmiller.core.domain.models.ElementUnique
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

import com.github.tacetfive.ironmiller.core.ui.theme.IronMillerTheme

@Composable
fun ElementsList(
    elements: ImmutableList<ElementUnique>,
    modifier: Modifier = Modifier,
    onItemClick: (/* */) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(RickAndMortyTheme.dimens.spacingXs),
        verticalArrangement = Arrangement.spacedBy(RickAndMortyTheme.dimens.spacingXs)
    ) {
        items(
            items = elements,
            key = { it.id }
        ) { episode ->
            EpisodeCard(
                episode = episode,
                modifier = Modifier.fillMaxWidth(),
                onClick = onItemClick
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun ElementsListPreview() {
    IronMillerTheme {
        ElementsList(
            elements = List(10) { i ->
                ElementUnique(
                    title = "mill",
                    titleShort = "mill",
                    flipPrefix = "x",
                    turn = 1,
                )
            }.toImmutableList()
        )
    }
}