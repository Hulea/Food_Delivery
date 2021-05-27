import React from "react";
import Sidemenu from './Menu';
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

class UserSearchFood extends React.Component{


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




    constructor(){
        super();
    }

    render(){
        return(
            <div>
                <Sidemenu></Sidemenu>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>

                    <h1>Welcome User</h1>

                </div>
            </div>
        )
    }

}

export default UserSearchFood;