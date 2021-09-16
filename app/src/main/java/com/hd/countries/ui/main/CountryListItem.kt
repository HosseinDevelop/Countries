package com.hd.countries.ui.main

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.hd.countries.data.model.Country
import com.hd.countries.ui.theme.Grey200
import com.hd.countries.ui.theme.Grey800

@Composable
fun CountryListItem(context: Context, country: Country, onItemClick: (country: Country) -> Unit) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(country) }
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        //.height(35.dp)
                        .width(50.dp)
                        .padding(2.dp),

                    //shape = RoundedCornerShape(100.dp),
                    shape = CircleShape, color = Grey200
                ) {
                    Text(
                        modifier = Modifier
                            .align(CenterVertically)
                            //.height(35.dp)
                            .width(50.dp)
                            .padding(4.dp), text = "${country.alpha2Code}", fontWeight = FontWeight.Bold, color = Grey800, textAlign = TextAlign.Center, style = MaterialTheme.typography.caption, overflow = TextOverflow.Ellipsis, maxLines = 1
                    )
                }

                Text(
                    text = ". ${country.name}", style = MaterialTheme.typography.body1, overflow = TextOverflow.Ellipsis
                )
                val imageLoader = ImageLoader.Builder(context).componentRegistry {
                    add(SvgDecoder(context))
                }.build()

                Spacer(modifier =Modifier.weight(1f))

                Image(painter = rememberImagePainter(imageLoader = imageLoader, data = country.flag, builder = {
                    crossfade(true)
                    transformations(
                        //GrayscaleTransformation(),       // Gray Scale Transformation
                        CircleCropTransformation()       // Circle Crop Transformation
                    )
                }), contentDescription = null, modifier = Modifier
                    .size(50.dp)
                    .align(CenterVertically))

            }

        }
        Divider(startIndent = 16.dp)
    }

}