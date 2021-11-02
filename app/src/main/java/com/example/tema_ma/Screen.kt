package com.example.tema_ma

sealed class Screen(val route : String)
{
    object MainList : Screen("main_list")
    object EditView : Screen("edit_screen")
    object AddView : Screen("add_view")
    fun withArgs(vararg args: Long?): String {
        return buildString {
            append(route)
            args.forEach { arg->append("/$arg") }
        }
    }
}
