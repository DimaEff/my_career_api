package ru.my_career.my_career_api.my_career_api.roles

const val PERMISSION_TITLE_SEPARATOR = ":"

fun checkIsValidPermissionTitle(title: String): Boolean {
    val permissionType = title.split(PERMISSION_TITLE_SEPARATOR)[1]
    return permissionType === PermissionType.WRITE.toString() || permissionType === PermissionType.READ.toString()
}

fun getPermissionTitle(title: String, permissionType: PermissionType): String =
    setOf<String>(permissionType.toString(), title).joinToString(separator = PERMISSION_TITLE_SEPARATOR)