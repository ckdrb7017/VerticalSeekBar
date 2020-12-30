# Vertical SeekBar
![GitHub release](https://img.shields.io/badge/release-v1.0.1-blue.svg)
![Bintray](https://img.shields.io/badge/bintray-v1.0.1-blue.svg)

## 1. Result
![ezgif com-gif-maker](https://user-images.githubusercontent.com/28835056/103124087-e9cf9b80-46c9-11eb-8c9e-46c6cc5126f2.gif)

## 2. Features
This is a library that lets you randomly place buttons.
I placed buttons based on ConstraintLayout and used my algorithm to prevent overlapping buttons.

## 3. Dependency
```
    implementation 'com.jakchang.taglayout:tag-layout:1.0.2'
```

## 4. Property

| Name | Format | Description |
|---|:---:|---|
| maxSize | string | this attribute means the maximum value of the selectable count |
| selectedBackgroundColor | color | this attribute means the color of the selected button background |
| unSelectedBackgroundColor | color | this attribute means the color of the unSelected button background |
| buttonWidth | dimension | this attribute means the button width |
| buttonHeight | dimension | this attribute means the button height |
| buttonPadding | dimension | this attribute means the button padding |
| isShuffled | boolean | this attribute means the shuffle flag of buttons |

## 5. Example Code

*xml code*
```
   <com.jakchang.taglayout.TagLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:entries="@array/testArray"
        app:maxSize="10"
        app:selectedBackgroundColor="@color/colorWhite"
        app:unSelectedBackgroundColor="@color/colorBlack"
        app:buttonWidth="100dp"
        app:buttonHeight="100dp"
        app:buttonPadding="10dp"
        app:isShuffled="false"
        />
```

*kotlin code*
```
        val dataList =arrayListOf("aaaaa","bbbbbb","cccccccccccccccccccccccccccc","dddddddddddddddddddddddddddd",
            "eeeee","ffffffffff","ggggggg","hhh","iii","jjjjj","kkkkk","l","m","n")


        val listener : TagButtonClickListener = object :TagButtonClickListener{
            override fun onRandomButtonClick(button: Button, index: Int) {
                Toast.makeText(this@MainActivity,"Button Text : ${button.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }

        myTagLayout.initButtonList(dataList)
        myTagLayout.setButtonClickListener(listener)
        myTagLayout.init()
```
## 6. Issue

When delivering a Drawable of the button, View do not render properly, so only the Color is changed.
Also, there is a problem that creates a gap when placed in ScrollView, so I'm currently working on it.

## 7. License

Copyright 2020 ckdrb7017

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations

