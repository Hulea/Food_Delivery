import React from "react";
import axiosInstance from "./axios";
import Sidemenu from './Menu';
import { Menu } from "@material-ui/core";
import {DataGrid}  from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
<<<<<<< HEAD
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4


const columns = [
    {field:'id',headerName:'Id',width:300},
    {field:'name',headerName:'Name',width:300},
    {field:'price',headerName:'Price',width:300},
    {field:'description',headerName:'Description',width:300},
]



class UserOrder extends React.Component{

<<<<<<< HEAD
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

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

    constructor(){
        super();

        console.log(localStorage.getItem("USER"));



        this.state = {
            orders:[],
            id:0,
            location:"",
        }

        this.deleteOrder = this.deleteOrder.bind(this)

        axiosInstance
        .get("/user/orders/" + localStorage.getItem("USER_ID"))
        .then( response =>{
            const val = response.data

            this.setState({orders:val});
            console.log(val);


            var sum = 0;
            for(let i = 0 ;i<response.data.length;i++){
                sum = sum + response.data[i].price;


             }
             console.log(sum);


             localStorage.setItem("SUM",sum);


        })
        .catch(error =>{
            console.log(error);
        })



    }



    removeFromOrder(){

        let boughtFood = localStorage.getItem("TODELETE")
        let userr = localStorage.getItem("USER_ID")

        console.log(boughtFood)
        console.log(userr)


        axiosInstance.post("/food/removefoodfromorder/" + userr + "/" + boughtFood)
        .then(console.log("ok delete"))
        .catch(error => {
            console.log(error)
        })
    }


    deleteOrder(){


        let toDelete = localStorage.getItem("USER_ID");

        console.log(toDelete);

        let transportDTO = {
            location:this.state.location,
            price:localStorage.getItem("SUM"),
            user:localStorage.getItem("USER_ID")
        }

        axiosInstance.post("/transport/add",transportDTO)
        .then(console.log("ok add transp"))
        .catch(error => {
            console.log(error)
        })

        axiosInstance.delete("/foodorder/delete/" + toDelete)
        .then(console.log("ok del"))
        .catch(error =>{
            console.log(error)
        })

    }

<<<<<<< HEAD
=======

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    handleInput = event => {

        const { value,name } = event.target;
        this.setState(
            {
                [name]: value
            }
        );
        console.log(value);
    };

    render(){
        return(
            <div>
                <Sidemenu></Sidemenu>

                <div style={{display: 'flex',  justifyContent:'left', alignItems:'center','margin-left':'100px','margin-bottom':'50px'}}>
<<<<<<< HEAD
                        <TextField
                        style={{'margin-right':'70px'}}
                        id="standard-basic"
=======
                        <TextField 
                        style={{'margin-right':'70px'}} 
                        id="standard-basic" 
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                        label="Location"
                        name="location"
                        onChange = {this.handleInput}
                        />
                </div>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                    <div style={{ display: 'flex', height: 600,width:1750 }}>
                        <div style={{ flexGrow: 5 }}>
                        <DataGrid rows={this.state.orders} columns={columns} pageSize={20} 
                        onRowSelected={(e => localStorage.setItem("TODELETE",e.data.name))}/>
                        </div>
                    </div>
                </div>

                <div style = {{'margin-left':'90px'}}>
                     <TextField disabled id="standard-disabled" label="Total price"  defaultValue = {localStorage.getItem("SUM")}  />
                 </div>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
<<<<<<< HEAD

                <div style = {{'margin-right':'20px'}}>
                        <Button
                                href="/user/order/cardpayment"
                                type = "submit"
                                variant="contained"
                                color="primary" >
                            Pay with card
                        </Button>
                    </div>

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                    <div style = {{'margin-right':'20px'}}>
                        <Button
                                onClick = {this.deleteOrder}
                                type = "submit"
                                variant="contained"
                                color="primary" >
                            Place Order
                        </Button>
                    </div>

                    <div>
                        <Button
                                onClick = {this.removeFromOrder}
                                type = "submit"
                                variant="contained"
                                color="secondary" >
                            Remove from order
                        </Button>
                    </div>
<<<<<<< HEAD

                    

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                </div>

            </div>
        )
    }

}

export default UserOrder;