# Vertical SeekBar
![GitHub release](https://img.shields.io/badge/release-v1.0.1-blue.svg)
![Bintray](https://img.shields.io/badge/bintray-v1.0.1-blue.svg)

## 1. Result
![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/28835056/103345075-c0e94500-4ad3-11eb-9438-47008b6dbcc3.gif)
## 2. Features
This is a library that lets you set a seekbar vertical.
I changed the concept between height and width.
And there is a some tools you can customized the radius or progress color.

## 3. Dependency
```
    implementation 'com.jakchang.vertical_seekbar:vertical-seekbar:1.0.1'
```

## 4. Property

| Name | Format | Description |
|---|:---:|---|
| seekBarColor | color | this attribute means the color of the seekbar background |
| progressColor | color | this attribute means the color of the progressbar |
| radius | float | this attribute means the radius of all side |
| topLeftRadius | float | this attribute means the topLeftRadius |
| topRightRadius | float | this attribute means the topRightRadius |
| bottomLeftRadius | float | this attribute means the bottomLeftRadius |
| bottomRightRadius | float | this attribute means the bottomRightRadius |

## 5. Example Code

*xml code*
```
    <com.jakchang.vertical_seekbar.VerticalSeekBar
        android:layout_width="100dp"
        android:layout_height="200dp"
        android:thumb="@drawable/seekbar_thumb"
        android:maxHeight="100dp"
        app:progressColor="@color/colorGreen"
        app:radius="100"
        app:seekBarColor="@color/colorOrange" />
```

## 6. Issue

    This seekbar is based on the concept of the change between height and width with rotation.
    So If you want to scale the width of the seekbar, you have to set the maxHeight as you see above example. 

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

