import {Menu, TextField} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import React from "react";
import axiosInstance from "./axios";
import Sidemenu from "./MenuAdmin";
import {Link} from "@material-ui/core";
import Container from "@material-ui/core/Container";
import axios from 'axios';


const columns = [
    {field:'id',headerName:'Id',width:50},
    {field:'firstName',headerName:'First Name',width:300},
    {field:'lastName',headerName:'Last Name',width:300},
    {field:'phoneNumber',headerName:'Phone Number',width:300},
    {field:'email',headerName:'Email',width:300},
    {field:'password',headerName:'Password',width:300},
    {field:'accountType',headerName:'Account Type',width:150},
]

class AdminEditUsers extends React.Component{

    constructor(){
        super();
        this.state = {
            users:[],
            id:0,
            firstname:"",
            lastname:"",
            phonenumber:"",
            email:"",
            password:""
        }

        this.onSubmitF = this.onSubmitF.bind(this)
        this.onSubmitDelete = this.onSubmitDelete.bind(this)
        this.onSubmitEdit = this.onSubmitEdit.bind(this)

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


    onSubmitF(){
        let newUser = {
            firstname:this.state.firstname,
            lastname:this.state.lastname,
            phonenumber:this.state.phonenumber,
            email:this.state.email,
            password:this.state.password

        }

        console.log(newUser)

        axiosInstance.post("/user/add",newUser)
        .then(console.log("ok"))
        .catch(error => {
            console.log(error)
        })
    }

    onSubmitDelete(){
        let delRes = this.state.id

        console.log(delRes)

        axiosInstance.delete("/user/delete/" + delRes)
        .then(console.log("ok del"))
        .catch(error =>{
            console.log(error)
        })
    }

    onSubmitEdit(){

        let newUser2 = {
            id:this.state.id,
            firstname:this.state.firstname,
            lastname:this.state.lastname,
            phonenumber:this.state.phonenumber,
            email:this.state.email,
            password:this.state.password

        }

        console.log(newUser2)


        axiosInstance.put("user/update",newUser2)
        .then(console.log("ok update"))
        .catch(error => {
            console.log(error)
        })
    }

    render(){
        return(

            <div>

                <Sidemenu></Sidemenu>


                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-right':'230px','margin-bottom':'50px'}}>

                
                <Container>
                    <div >
                        <TextField 
                        style={{'margin-right':'70px'}} 
                        id="standard-basic" 
                        label="Id"
                        name="id"
                        onChange = {this.handleInput} 
                        
                        />

                        <TextField 
                        id="standard-basic" 
                        label="First Name"
                        onChange = {this.handleInput} 
                        name = "firstname" />
                    </div>
                    <div>
                        <TextField 
                        style={{'margin-right':'70px'}} 
                        id="standard-basic" 
                        label="Last Name"
                        onChange = {this.handleInput} 
                        name = "lastname" />

                        <TextField 
                        id="standard-basic" 
                        label="Phone Number"
                        onChange = {this.handleInput} 
                        name = "phonenumber" />
                    </div>
                    <div>
                        <TextField 
                        style={{'margin-right':'70px'}} 
                        id="standard-basic" 
                        label="Email"
                        onChange = {this.handleInput} 
                        name = "email" />

                        <TextField id="standard-basic" 
                        label="Password"
                        onChange = {this.handleInput} 
                        name = "password" />
                    </div>
                </Container>


                <div style = {{'margin-right':'20px'}}>
                    <Button
                            onClick={this.onSubmitF}
                            type = "submit"
                            variant="contained"
                            color="primary" >
                        Add
                    </Button>
                </div>

                <div style = {{'margin-right':'20px'}}>
                    <Button 
                            onClick={this.onSubmitEdit}
                            type = "submit"
                            variant="contained"
                            color="inherit" >
                        Edit
                    </Button>
                </div>

                <div style = {{'margin-right':'20px'}}>
                    <Button
                            onClick={this.onSubmitDelete}
                            type = "submit"
                            variant="contained"
                            color="secondary" >
                        Delete
                    </Button>
                </div>

                </div>

          

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                    <div style={{ display: 'flex', height: 600,width:1750 }}>
                        <div style={{ flexGrow: 5 }}>
                            <DataGrid rows={this.state.users} columns={columns} pageSize={20}/>
                        </div>
                    </div>
                </div>


                


            </div>

        )
    }

}

export default AdminEditUsers;