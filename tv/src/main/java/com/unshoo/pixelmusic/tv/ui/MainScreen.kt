package com.unshoo.pixelmusic.tv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.fillMaxWidth
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.foundation.lazy.grid.TvLazyGridScope
import androidx.tv.foundation.lazy.grid.TvLazyHorizontalGrid
import androidx.tv.foundation.lazy.grid.items
import androidx.tv.foundation.lazy.grid.rememberTvLazyGridState
import androidx.tv.material3.Card
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.PrimaryNavigationDrawer
import androidx.tv.material3.TvMaterialTheme
import coil.compose.rememberImagePainter
import com.unshoo.pixelmusic.tv.di.rememberPlatformImageLoader
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(
        TabItem("Library", "music.note.list"),
        TabItem("Search", "magnifyingglass"),
        TabItem("Playlists", "music.note.list"),
        TabItem("Radio", "radio"),
        TabItem("Settings", "gearshape")
    )

    val navigationDrawerState = rememberNavigationDrawerState(initialValue = false)
    val scope = rememberCoroutineScope()

    TvMaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PrimaryNavigationDrawer(
                drawerState = navigationDrawerState,
                drawerContent = {
                    NavigationDrawerContent(
                        tabs = tabs,
                        selectedTab = selectedTab,
                        onTabClick = { index ->
                            selectedTab = index
                            scope.launch { navigationDrawerState.close() }
                        }
                    )
                },
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        // Header with app title and selected tab
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 48.dp, vertical = 24.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Pixel Music",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Text(
                                text = tabs[selectedTab].title,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Content area
                        when (selectedTab) {
                            0 -> LibraryContent()
                            1 -> SearchContent()
                            2 -> PlaylistsContent()
                            3 -> RadioContent()
                            4 -> SettingsContent()
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationDrawerContent(
    tabs: List<TabItem>,
    selectedTab: Int,
    onTabClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 48.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            NavigationDrawerItem(
                text = { Text(text = tab.title, fontSize = 20.sp) },
                selected = selectedTab == index,
                onClick = { onTabClick(index) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun LibraryContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Recently Played Section
        SectionHeader("Recently Played")

        TvLazyHorizontalGrid(
            state = rememberTvLazyGridState(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInMainAxis = 2
        ) {
            items(6) { index ->
                MediaCard(
                    title = "Album ${index + 1}",
                    subtitle = "Artist ${index + 1}",
                    imageUrl = "https://picsum.photos/seed/album$index/300/300",
                    onClick = { /* Handle click */ }
                )
            }
        }

        // Artists Section
        SectionHeader("Artists")

        TvLazyHorizontalGrid(
            state = rememberTvLazyGridState(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInMainAxis = 3
        ) {
            items(9) { index ->
                MediaCard(
                    title = "Artist ${index + 1}",
                    subtitle = "${(index * 5) + 10} songs",
                    imageUrl = "https://picsum.photos/seed/artist$index/200/200",
                    isRound = true,
                    onClick = { /* Handle click */ }
                )
            }
        }

        // Albums Section
        SectionHeader("Albums")

        TvLazyHorizontalGrid(
            state = rememberTvLazyGridState(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInMainAxis = 4
        ) {
            items(8) { index ->
                MediaCard(
                    title = "Album ${index + 1}",
                    subtitle = "Artist ${(index % 3) + 1}",
                    imageUrl = "https://picsum.photos/seed/album2$index/250/250",
                    onClick = { /* Handle click */ }
                )
            }
        }
    }
}

@Composable
fun SearchContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionHeader("Search")

        // Search input placeholder
        androidx.tv.material3.SearchBar(
            query = "",
            onQueryChange = { },
            onSearchClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
        )

        Text(
            text = "Search for songs, artists, albums, and playlists from YouTube Music and your local library.",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 48.dp)
        )
    }
}

@Composable
fun PlaylistsContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionHeader("Your Playlists")

        TvLazyHorizontalGrid(
            state = rememberTvLazyGridState(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInMainAxis = 3
        ) {
            items(6) { index ->
                MediaCard(
                    title = "Playlist ${index + 1}",
                    subtitle = "${(index + 1) * 15} songs",
                    imageUrl = "https://picsum.photos/seed/playlist$index/300/300",
                    onClick = { /* Handle click */ }
                )
            }
        }

        // Create new playlist card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .height(300.dp),
            onClick = { /* Create playlist */ },
            colors = androidx.tv.material3.CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                androidx.compose.material3.Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.AddCircle,
                    contentDescription = "Create playlist",
                    tint = MaterialTheme.colorScheme.primary,
                    size = 64.dp
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = "Create New Playlist",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun RadioContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionHeader("Radio Stations")

        TvLazyHorizontalGrid(
            state = rememberTvLazyGridState(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInMainAxis = 4
        ) {
            items(8) { index ->
                MediaCard(
                    title = "Radio ${index + 1}",
                    subtitle = "Genre ${index + 1}",
                    imageUrl = "https://picsum.photos/seed/radio$index/300/200",
                    onClick = { /* Handle click */ }
                )
            }
        }
    }
}

@Composable
fun SettingsContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SectionHeader("Settings")

        // Settings list
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SettingItem("Audio Quality", "High (320 kbps)", "audiotrack")
            SettingItem("Equalizer", "10-band EQ with presets", "equalizer")
            SettingItem("Crossfade", "5 seconds", "swap.horiz")
            SettingItem("Sleep Timer", "Off", "bedtime")
            SettingItem("Theme", "System Default", "palette")
            SettingItem("Downloads", "Wi-Fi Only", "wifi")
            SettingItem("Account", "Connected to YouTube Music", "person")
            SettingItem("About", "Version 1.0.0", "info")
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(horizontal = 48.dp, bottom = 8.dp)
    )
}

@Composable
fun MediaCard(
    title: String,
    subtitle: String,
    imageUrl: String,
    isRound: Boolean = false,
    onClick: () -> Unit
) {
    val imageLoader = rememberPlatformImageLoader()
    val imageUri = imageLoader.loadImage(imageUrl) as android.net.Uri
    val painter = coil.compose.rememberImagePainter(imageUri, builder = {
        crossfade(true)
    })
    Card(
        onClick = onClick,
        modifier = Modifier
            .size(if (isRound) 200.dp else 300.dp, if (isRound) 200.dp else 300.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Image
            androidx.compose.foundation.Image(
                painter = painter,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            // Text info
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.TextOverflow.Ellipsis
                )
                Text(
                    text = subtitle,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun SettingItem(title: String, value: String, iconName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(
                imageVector = getIcon(iconName),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                size = 24.dp
            )
            Text(
                text = title,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Text(
            text = value,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

fun getIcon(name: String) = androidx.compose.material.icons.Icons.Default.AddCircle // Placeholder

data class TabItem(
    val title: String,
    val iconName: String
)