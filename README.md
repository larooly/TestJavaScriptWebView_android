# TestJavaScriptWebView_android
share event to javascript and android WebView<br>
HTML(WebView) <-> Java 가 서로 이벤트를 받을수 있는지에 대한 테스트 <br>
<img src = "https://user-images.githubusercontent.com/33897259/145938490-c3393f4e-799d-4215-9836-4faf98806969.png" width = "300" height = "600" ><br>
하얀 부분은 webview / 색이 있는 부분이 App 
위쪽부분(Html 파일 하나로 만들고 WebView에 연결한 방식)
- WebView 버튼 -> App 으로 값 전송
- 붉은 App 버튼 -> Webview 에 값 전송 

아래쪽 부분 (위와 달리 javaScript를 따로 작성하는 방식)
- WebView 버튼 -> app 쪽에 로그가 찍힘
- 파란 App 버튼 -> javaScript 쪽 함수를 통해 값을 버튼에게 넣어줌 
