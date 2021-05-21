import React from "react";
import axios from 'axios';
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";


export default class WebSocket extends React.Component {
    constructor() {
        super()
        this.state = {
        }
    };

    componentDidMount() {
        this.connect();
    };

    connect() {
        const URL = "http://localhost:8081/socket";
        const websocket = new SockJS(URL);
        const stompClient = Stomp.over(websocket);
        stompClient.connect({}, frame => {
            console.log(frame);
            stompClient.subscribe("/topic/socket/notif2", notification => {
                let message = notification.body;
                alert(message);
            })
        })
    }


    render() {
        return (
            <h1>bosssss</h1>
        )
    }

}