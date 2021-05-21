import {Menu, TextField} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import React from "react";
import axiosInstance from "./axios";
import Sidemenu from "./MenuAdmin";
import {Link} from "@material-ui/core";
import Container from "@material-ui/core/Container";

const columns = [
    {field:'id',headerName:'Id',width:50},
    {field:'firstName',headerName:'First Name',width:150},
    {field:'lastName',headerName:'Last Name',width:150},
    {field:'phoneNumber',headerName:'Phone Number',width:150},
    {field:'email',headerName:'Email',width:200},
    {field:'password',headerName:'Password',width:150},
    {field:'accountType',headerName:'Account Type',width:100},
    {field:'loginTime',headerName:'Login Time',width:150},
    {field:'logoutTime',headerName:'Logout Time',width:150},
    {field:'logged',headerName:'Logged',width:150},
]

var nrr;

export default class AdminViewTimestamps extends React.Component{


    constructor(){
        super();

        this.state={
            users:[],
            nr:[]
        }


        axiosInstance
        .get("/user/allusers")
        .then( response =>{
            const val = response.data

            this.setState({users:val});
            console.log(val);
        })
        .catch(error =>{
            console.log(error);
        })

        axiosInstance
        .get("/user/loggedusers")
        .then( response =>{
            const val = response.data
            nrr = val
            this.setState({nr:nrr});
            console.log("active users: " + this.state.nr.toString());
        })
        .catch(error =>{
            console.log(error);
        })

    }



    render(){
        return(

            <div>
                <Sidemenu></Sidemenu>

                <div style = {{'margin-left':'90px'}}>
                     <TextField disabled id="standard-disabled" label={"Number of active users: " + this.state.nr.toString()} />
                 </div>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                    <div style={{ display: 'flex', height: 600,width:1750 }}>
                        <div style={{ flexGrow: 5 }}>
                            <DataGrid rows={this.state.users} columns={columns} pageSize={20}/>
                        </div>
                    </div>
                </div>

            </div>

        );
    }

}