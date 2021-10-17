package com.brighter_bee.tech.game_of_thrones.features.house.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.brighter_bee.tech.game_of_thrones.core.components.Heading
import com.brighter_bee.tech.game_of_thrones.core.methods.characterImageId
import com.brighter_bee.tech.game_of_thrones.core.methods.houseImageId
import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House

@Composable
fun HouseDetailScreen(house: House) {
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            
            Box {
                Image(
                    painter = painterResource(id = houseImageId(house.slug)),
                    contentDescription = house.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp),
                    contentScale = ContentScale.FillBounds,
                )

                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(color = MaterialTheme.colors.secondaryVariant)
                        .align(Alignment.BottomEnd),
                ) {
                    Text(
                        text = house.name,
                        style = MaterialTheme.typography.body1.copy(color = Color.White),
                        modifier = Modifier.padding(
                            vertical = 4.dp,
                            horizontal = 8.dp,
                        ),
                    )
                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Heading("Members")

            LazyRow(
                Modifier.padding(
                    start = 24.dp,
                    top = 24.dp,
                    bottom = 4.dp,
                )
            ) {
                items(house.members) { member ->
                    Column(modifier = Modifier.padding(end = 24.dp)) {

                        Image(
                            painter = painterResource(id = characterImageId(member.slug)),
                            contentDescription = member.name,
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.large)
                                .size(width = 200.dp, height = 240.dp),
                            contentScale = ContentScale.FillBounds,
                        )
                        Text(
                            text = member.name,
                            modifier = Modifier.padding(start = 2.dp,top = 4.dp),
                            style = MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.W500,
                                color = Color.White,
                            ),
                        )
                    }
                }
            }

        }
    }
    
}