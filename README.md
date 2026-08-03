<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/nav_graph"
    app:startDestination="@id/splashFragment">

    <fragment
        android:id="@+id/splashFragment"
        android:name="com.example.todoapp.ui.splash.SplashFragment"
        android:label="Splash">
        <action
            android:id="@+id/action_splash_to_home"
            app:destination="@id/homeFragment"
            app:popUpTo="@id/splashFragment"
            app:popUpToInclusive="true" />
    </fragment>

    <fragment
        android:id="@+id/homeFragment"
        android:name="com.example.todoapp.ui.home.HomeFragment"
        android:label="@string/app_name">
        <action
            android:id="@+id/action_home_to_addTodo"
            app:destination="@id/addTodoFragment" />
        <action
            android:id="@+id/action_home_to_detail"
            app:destination="@id/todoDetailFragment" />
    </fragment>

    <fragment
        android:id="@+id/addTodoFragment"
        android:name="com.example.todoapp.ui.add.AddTodoFragment"
        android:label="@string/add_todo_title" />

    <fragment
        android:id="@+id/todoDetailFragment"
        android:name="com.example.todoapp.ui.detail.TodoDetailFragment"
        android:label="@string/todo_details_title">
        <argument
            android:name="todoId"
            app:argType="long" />
    </fragment>

</navigation>
