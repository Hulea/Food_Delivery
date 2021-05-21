import React from "react";
import axiosInstance from "./axios";
import Sidemenu from './Menu';
import { Menu } from "@material-ui/core";
import {Button} from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';


function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}



export default class InviteAFriend extends React.Component{

    constructor(){

        super();

        this.state = {
            email:""
        };

        this.sendEmail = this.sendEmail.bind(this)

    }


    handleInput = event => {

        const { value,name } = event.target;
        this.setState(
            {
                [name]: value
            }
        );
        console.log(value);
    };


    sendEmail(){


        let emailAux = this.state.email

        console.log(emailAux + "........")


        if(validateEmail(emailAux)){
        axiosInstance.post("/invite/" + emailAux)
        .then(console.log("invite email ok"))
        .catch(error => {
            console.log(error)
        })
        }
        else{
            alert("Invalid email!")
        }


    }


    render(){
        return(


            <div>
                <Sidemenu></Sidemenu>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>

                        <TextField
                                style={{'margin-right':'70px'}}
                                id="standard-basic"
                                label="Email"
                                name="email"
                                onChange = {this.handleInput}

                        />

                        <Button
                                onClick={this.sendEmail}
                                type = "submit"
                                variant="contained"
                                color="primary" >
                            Send
                        </Button>

                </div>
            </div>


        )
    }
}

