package com.quibbly.githubsearch.ui.assets

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Github: ImageVector
    get() {
        if (_icGithub != null) {
            return _icGithub!!
        }
        _icGithub = Builder(name = "IcGithub", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero) {
                moveToRelative(8.564f, 23.5f)
                curveToRelative(-0.089f, 0.0f, -0.187f, -0.008f, -0.292f, -0.028f)
                curveToRelative(-4.973f, -1.617f, -8.272f, -6.109f, -8.272f, -11.193f)
                curveToRelative(0.0f, -6.495f, 5.383f, -11.779f, 12.0f, -11.779f)
                reflectiveCurveToRelative(12.0f, 5.284f, 12.0f, 11.779f)
                curveToRelative(0.0f, 5.091f, -3.312f, 9.577f, -8.24f, 11.162f)
                curveToRelative(-0.569f, 0.113f, -0.893f, -0.044f, -1.073f, -0.193f)
                curveToRelative(-0.235f, -0.194f, -0.37f, -0.493f, -0.37f, -0.819f)
                lineToRelative(0.004f, -0.624f)
                curveToRelative(0.004f, -0.579f, 0.011f, -1.456f, 0.011f, -2.465f)
                curveToRelative(0.0f, -1.114f, -0.458f, -1.586f, -0.598f, -1.704f)
                curveToRelative(-0.153f, -0.129f, -0.215f, -0.337f, -0.157f, -0.528f)
                curveToRelative(0.059f, -0.192f, 0.226f, -0.33f, 0.425f, -0.352f)
                curveToRelative(2.374f, -0.257f, 4.801f, -1.061f, 4.801f, -5.067f)
                curveToRelative(0.0f, -1.036f, -0.352f, -1.939f, -1.045f, -2.687f)
                curveToRelative(-0.132f, -0.142f, -0.17f, -0.348f, -0.097f, -0.528f)
                curveToRelative(0.101f, -0.25f, 0.379f, -1.116f, -0.011f, -2.321f)
                curveToRelative(-0.356f, 0.028f, -1.172f, 0.202f, -2.511f, 1.096f)
                curveToRelative(-0.12f, 0.08f, -0.271f, 0.104f, -0.409f, 0.066f)
                curveToRelative(-0.864f, -0.235f, -1.788f, -0.357f, -2.747f, -0.363f)
                curveToRelative(-0.954f, 0.005f, -1.877f, 0.127f, -2.74f, 0.363f)
                curveToRelative(-0.14f, 0.039f, -0.288f, 0.017f, -0.41f, -0.065f)
                curveToRelative(-1.341f, -0.889f, -2.16f, -1.066f, -2.528f, -1.093f)
                curveToRelative(-0.422f, 1.309f, -0.05f, 2.196f, -0.003f, 2.299f)
                curveToRelative(0.084f, 0.184f, 0.048f, 0.401f, -0.09f, 0.548f)
                curveToRelative(-0.696f, 0.746f, -1.049f, 1.649f, -1.049f, 2.686f)
                curveToRelative(0.0f, 4.008f, 2.423f, 4.815f, 4.793f, 5.077f)
                curveToRelative(0.198f, 0.022f, 0.364f, 0.159f, 0.423f, 0.35f)
                curveToRelative(0.059f, 0.19f, 0.0f, 0.397f, -0.152f, 0.527f)
                curveToRelative(-0.166f, 0.142f, -0.458f, 0.487f, -0.559f, 1.2f)
                curveToRelative(-0.024f, 0.171f, -0.136f, 0.318f, -0.294f, 0.388f)
                curveToRelative(-0.614f, 0.27f, -2.717f, 0.983f, -3.98f, -1.141f)
                curveToRelative(-0.004f, -0.007f, -0.088f, -0.151f, -0.246f, -0.323f)
                curveToRelative(0.197f, 0.268f, 0.4f, 0.614f, 0.577f, 1.054f)
                curveToRelative(0.036f, 0.107f, 0.622f, 1.785f, 3.306f, 1.21f)
                curveToRelative(0.149f, -0.032f, 0.301f, 0.006f, 0.417f, 0.1f)
                curveToRelative(0.117f, 0.094f, 0.186f, 0.236f, 0.187f, 0.387f)
                lineToRelative(0.014f, 1.92f)
                curveToRelative(0.0f, 0.325f, -0.135f, 0.624f, -0.371f, 0.819f)
                curveToRelative(-0.142f, 0.118f, -0.373f, 0.242f, -0.714f, 0.242f)
                close()
                moveTo(12.0f, 1.5f)
                curveToRelative(-6.065f, 0.0f, -11.0f, 4.835f, -11.0f, 10.779f)
                curveToRelative(0.0f, 4.65f, 3.021f, 8.759f, 7.518f, 10.226f)
                curveToRelative(0.054f, 0.008f, 0.11f, -0.01f, 0.121f, -0.017f)
                lineToRelative(0.005f, -0.623f)
                lineToRelative(-0.005f, -0.755f)
                curveToRelative(-3.092f, 0.374f, -3.848f, -1.931f, -3.856f, -1.956f)
                curveToRelative(-0.417f, -1.032f, -0.994f, -1.333f, -1.019f, -1.346f)
                curveToRelative(-0.281f, -0.183f, -0.865f, -0.574f, -0.698f, -1.11f)
                curveToRelative(0.15f, -0.484f, 0.765f, -0.528f, 1.001f, -0.526f)
                curveToRelative(1.437f, 0.098f, 2.162f, 1.364f, 2.192f, 1.417f)
                curveToRelative(0.701f, 1.177f, 1.77f, 1.066f, 2.471f, 0.82f)
                curveToRelative(0.062f, -0.279f, 0.152f, -0.538f, 0.269f, -0.77f)
                curveToRelative(-2.281f, -0.406f, -4.836f, -1.62f, -4.836f, -5.951f)
                curveToRelative(0.0f, -1.192f, 0.374f, -2.246f, 1.112f, -3.134f)
                curveToRelative(-0.164f, -0.537f, -0.355f, -1.647f, 0.208f, -3.061f)
                curveToRelative(0.055f, -0.14f, 0.171f, -0.247f, 0.314f, -0.292f)
                curveToRelative(0.194f, -0.059f, 1.246f, -0.284f, 3.4f, 1.093f)
                curveToRelative(0.883f, -0.221f, 1.819f, -0.335f, 2.785f, -0.341f)
                curveToRelative(0.971f, 0.005f, 1.906f, 0.12f, 2.79f, 0.34f)
                curveToRelative(2.143f, -1.377f, 3.193f, -1.153f, 3.386f, -1.093f)
                curveToRelative(0.144f, 0.045f, 0.259f, 0.152f, 0.314f, 0.292f)
                curveToRelative(0.549f, 1.38f, 0.378f, 2.494f, 0.216f, 3.057f)
                curveToRelative(0.739f, 0.892f, 1.113f, 1.946f, 1.113f, 3.14f)
                curveToRelative(0.0f, 4.329f, -2.556f, 5.539f, -4.839f, 5.942f)
                curveToRelative(0.239f, 0.476f, 0.369f, 1.062f, 0.369f, 1.709f)
                curveToRelative(0.0f, 1.013f, -0.006f, 1.892f, -0.011f, 2.473f)
                lineToRelative(-0.004f, 0.616f)
                curveToRelative(0.017f, 0.054f, 0.078f, 0.069f, 0.197f, 0.044f)
                curveToRelative(4.454f, -1.435f, 7.487f, -5.538f, 7.487f, -10.194f)
                curveToRelative(0.0f, -5.944f, -4.935f, -10.779f, -11.0f, -10.779f)
                close()
            }
        }
            .build()
        return _icGithub!!
    }

private var _icGithub: ImageVector? = null