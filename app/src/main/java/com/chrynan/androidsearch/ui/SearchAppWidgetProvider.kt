package com.chrynan.androidsearch.ui

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.ui.activity.SearchActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SearchAppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val searchIntent = Intent(context, SearchActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, searchIntent, 0)

        for (i in 0 until appWidgetIds.size) {
            val appWidgetId = appWidgetIds[i]

            val remoteViews = RemoteViews(context.packageName, R.layout.layout_app_widget).apply {
                setOnClickPendingIntent(R.id.appWidgetImageView, pendingIntent)
                setImageViewResource(R.id.appWidgetImageView, R.drawable.app_widget)
            }

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }
    }
}