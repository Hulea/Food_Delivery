import React from "react";
import axiosInstance from "./axios";
import Sidemenu from './Menu';
import { Menu } from "@material-ui/core";
import {DataGrid}  from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import 'react-credit-cards/es/styles-compiled.css';
import Cards from 'react-credit-cards';



class CardPayment extends React.Component{

    constructor(){

        super();

        console.log(localStorage.getItem("USER"));
        console.log(localStorage.getItem("SUM"));


        this.state = {
            cvc: '',
            expiry: '',
            focus: '',
            name: '',
            number: '',
            location:"",
          };


          this.deleteOrder = this.deleteOrder.bind(this)
    }

      handleInputFocus = (e) => {
        this.setState({ focus: e.target.name });
      }

      handleInputChange = (e) => {
        const { name, value } = e.target;

        this.setState({ [name]: value });
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



      deleteOrder(){


        let toDelete = localStorage.getItem("USER_ID");

        console.log(toDelete);

        console.log(this.state.location)

        let transportDTO = {
            location:this.state.location,
            price:localStorage.getItem("SUM"),
            user:localStorage.getItem("USER_ID"),
            number:this.state.number,
            name:this.state.name,
            expiry:this.state.expiry,
            cvc:this.state.cvc
        }

        axiosInstance.post("/transport/addwithcard",transportDTO)
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






    render(){


        return(

            <div>
                <Sidemenu></Sidemenu>
           
                <TextField  
                        style={{'margin-left':'70px','margin-bottom':'30px'}} 
                        id="standard-basic" 
                        label="Location"
                        name="location"
                        onChange = {this.handleInput}
                        />

                    <div id="PaymentForm">
                    <Cards
                    cvc={this.state.cvc}
                    expiry={this.state.expiry}
                    focused={this.state.focus}
                    name={this.state.name}
                    number={this.state.number}
                    />

                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'100px'}}>
                        
                        <div >
                        <form>
                            <input
                            type="tel"
                            name="number"
                            placeholder="Card Number"
                            onChange = {this.handleInput}
                            onFocus={this.handleInputFocus}
                        />
                        </form>
                      
                        <div style={{'margin-top':'20px'}}>
                          <form>
                            <input
                            type="text"
                            name="name"
                            placeholder="Name"
                            onChange = {this.handleInput}
                            onFocus={this.handleInputFocus}
                        />
                        </form>
                        </div>

                        <div style={{'margin-top':'20px'}}>
                          <form>
                            <input
                            type="text"
                            name="expiry"
                            placeholder="Valid Thru"
                            onChange = {this.handleInput}
                            onFocus={this.handleInputFocus}
                        />
                        </form>
                        </div>

                        <div style={{'margin-top':'20px'}}>
                          <form>
                            <input
                            type="text"
                            name="cvc"
                            placeholder="CVC"
                            pattern="\d{3,4}"
                            onChange = {this.handleInput}
                            onFocus={this.handleInputFocus}
                        />
                        </form>
                        </div>


                        </div>

                    </div>

                    </div>


                    <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>

                        <Button

                        onClick = {this.deleteOrder}
                        type = "submit"
                        variant="contained"
                        color="primary" >
                        Pay
                        </Button>

                    </div>
            </div>

        );

    }

}

export default CardPayment;