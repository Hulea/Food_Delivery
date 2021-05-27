import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "./axios";
import {Grid} from "@material-ui/core";
import Recaptcha from "react-google-recaptcha";


class Login extends React.Component{

    constructor(){
        super();
        this.state = {
            email: "",
            password: "",
            isVerified:false,
            loginSuccess:{
                role: "",
                id: 0
            }
        };

        this.recaptchaLoaded = this.recaptchaLoaded.bind(this);
        this.verifyCallback = this.verifyCallback.bind(this);
        this.verifyEmail = this.verifyEmail.bind(this);
    }


    verifyEmail = mail =>{
        let pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);

        if (!pattern.test(mail))
           return false;


    }


    recaptchaLoaded() {
        console.log('capcha successfully loaded');
    }

    verifyCallback(response) {
        if (response) {
            this.setState({
                isVerified: true
            })
        }



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

    onSubmitFun = event => {
        event.preventDefault();
        console.log(this.state.isVerified);
        //if(this.state.isVerified){
            let credentials = {
                email : this.state.email,
                password : this.state.password
            }


            console.log(credentials);

            axiosInstance.post("/login",credentials)
            .then(
                res => {
                    const val = res.data;
                    this.setState(
                        {
                            loginSuccess: val
                        }
                    );
                    console.log("Success");
                    console.log(this.state.loginSuccess);

                    localStorage.setItem("USER",res.data.role);
                    localStorage.setItem("USER_ID",res.data.id);

                    console.log(this.state.loginSuccess.role);
                    if(this.state.loginSuccess.role === "ADMIN"){
                        this.props.history.push("/admin");
                    }
                    if(this.state.loginSuccess.role === "USER"){
                        this.props.history.push("/user");
                    }
                    if(this.state.loginSuccess.role === "WORKER"){
                        this.props.history.push("/worker");
                    }
                }
            )
        .catch(error => {
            console.log(error)
        })

        console.log(this.state.email);

        axiosInstance.post("user/timestamp/login",credentials.email)
        .then(console.log("login timestamp?"))
        .catch(error => {
            console.log(error)
        })
        


      
    }



    render(){

        return(

            <Container maxWidth="sm">
                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center', height: '100vh'}}>
                    <Grid>


                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <h1 style={{alignItems:'center'}}>
                            Log In
                        </h1>
                    </div>

                        <form onSubmit={this.onSubmitFun}>
                            <TextField
                             variant="outlined"
                             margin="normal"
                             required
                             fullWidth
                             id="email"
                             label="Email"
                             name="email"
                             autoComplete="string"
                             onChange={this.handleInput}
                             autoFocus
                            />

                            <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Password"
                            type="password"
                            id="password"
                            onChange={this.handleInput}
                            autoComplete="current-password"
                            />

                            <div style = {{'margin-top':'20px'}}>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary" >
                                Sign In
                            </Button>
                            </div>

                            <div style = {{'margin-top':'20px'}}>
                            <Button
                                href="/register"
                                fullWidth
                                variant="contained"
                                color="primary" >
                                Register
                            </Button>
                            </div>


                            <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
                                <Recaptcha
                                sitekey="insert your sitekey here"
                                render="explicit"
                                onloadCallback={this.recaptchaLoaded}
                                verifyCallback={this.verifyCallback}
                                />
                            </div>

                        </form>
                    </Grid>
                </div>
            </Container>

        )

    }

}

export default Login;
