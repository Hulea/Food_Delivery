import { Container, TextField,Checkbox,FormControlLabel,Button } from "@material-ui/core";
import React from "react";
import {Grid} from "@material-ui/core";
import NiceInputPassword from 'react-nice-input-password';
import 'react-nice-input-password/dist/react-nice-input-password.css';
import axiosInstance from "./axios";
import {Link} from "@material-ui/core";



const columns = [
    {field:'id',headerName:'Id',width:50},
    {field:'firstName',headerName:'First Name',width:300},
    {field:'lastName',headerName:'Last Name',width:300},
    {field:'phoneNumber',headerName:'Phone Number',width:300},
    {field:'email',headerName:'Email',width:300},
    {field:'password',headerName:'Password',width:300},
    {field:'accountType',headerName:'Account Type',width:150},
]


function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}


class Register extends React.Component{

    constructor(){
        super();
        this.state = {
            firstname:"",
            lastname:"",
            phonenumber:"",
            email:"",
            password:""
        }

        this.onSubmitF = this.onSubmitF.bind(this);


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

        if(validateEmail(newUser.email)){
        axiosInstance.post("/user/add",newUser)
        .then(console.log("ok"))
        .catch(error => {
            console.log(error)
        })

        axiosInstance.post("/register/" + newUser.email,newUser.email)
        .then(console.log("ok register"))
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

            <Container>
                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center', height: '100vh'}}>

                    <Grid>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <h1 style={{alignItems:'center'}}>
                            Register
                        </h1>
                    </div>


                    <form onSubmit={this.onSubmitFun}>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            style = {{width: 500}}
                            id="firstname"
                            label="First name"
                            name="firstname"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                    </div>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            style = {{width: 500}}
                            id="lastname"
                            label="Last name"
                            name="lastname"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                    </div>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            style = {{width: 500}}
                            id="phonenumber"
                            label="Phone Number"
                            name="phonenumber"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                    </div>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            style = {{width: 500}}
                            id="email"
                            label="Email"
                            name="email"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                    </div>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            style = {{width: 500}}
                            id="password"
                            label="Password"
                            name="password"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                    </div>

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <FormControlLabel
                            value="top"
                            control={<Checkbox color="primary" />}
                            label="Accept terms and conditions"
                            labelPlacement="end"
                        />
                    </div>


                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
                        <Button

                            style = {{width: 200,height:50}}
                            onClick={this.onSubmitF}
                            type="submit"
                            fullWidth
                            variant="contained"
                            color="primary"
                            href="/login"
                             >
                            Register
                        </Button>
                    </div>



                    </form>


                    </Grid>


                </div>
           </Container>
        )
    }

}

export default Register;