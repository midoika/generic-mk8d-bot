package me.notsmatch.kyoshubot.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject

/**
 * @param title タイトル
 * @param hour 1 ~ 24で時間を指定
 * @param need 募集人数
 * @param kyoshuUsers 挙手してるユーザー
 */
data class Koumoku(val title: String, val hour: Int, val need: Int, val kyoshuUsers: MutableList<Long>) {

    /**
     * @return JsonObjectにして返します
     */
    fun toJsonObject() : JsonObject {
        val returnJson = JsonObject()
        returnJson.addProperty("title", title)
        returnJson.addProperty("hour", hour)
        returnJson.addProperty("need", need)

        val array = JsonArray()
        kyoshuUsers.forEach{ id ->
            val json = JsonObject()
            json.addProperty("id", id)
            array.add(json)
        }

        returnJson.addProperty("kyoshuUsers", array.toString())

        return returnJson
    }
}