package ui.errors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NetworkErrorCard(exception: Exception) {
    Card(
        modifier = Modifier.padding(8.dp).wrapContentHeight().fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.error,
        contentColor = MaterialTheme.colors.onError,
    ) {
        Column {
            Text(text = exception.message.toString())
            Text(text = exception.cause.toString())
            Text(text = exception.toString())
        }
    }
}