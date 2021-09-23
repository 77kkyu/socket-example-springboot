# Description
 - auth : 77kkyu
 - development environment : spring-boot 
 - technology : websocket, javascript-websocket
---
# WebSocket

- 웹 소켓 프로토콜은 TCP기반으로 클라이언트와 서버 간 양방향, 전이중 통신을 표준화된 방법으로 제공한다.
- 웹소켓의 상호작용은 HTTP 요청에 Upgrade 헤더를 사용하여 웹 소켓 프로토콜로 스위치 한다.

---
## Request
    GET /websocket/chat HTTP/1.1
    Host: localhost:8080
    Upgrade: websocket // (1)
    Connection: Upgrade // (2)
    Sec-WebSocket-Key: QUIQmkdoq123asodqdpwqeWOE==
    Sec-WebSocket-Protocol: v10.stomp, v11.stomp
    Sec-WebSocket-Version: 13
    Origin: http://localhost:8080
---

## Response

    HTTP/1.1 101 Switching Protocols
    Upgrade: websocket
    Connection: Upgrade
    Sec-WebSocket-Accept: 1qwduiEio2NSDuoiqdpwqeWOE==
    Sec-WebSocket-Protocol: v10.stomp

---
![image](Assets/img01.png)