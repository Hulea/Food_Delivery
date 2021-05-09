import React from "react";
import Sidemenu from './Menu';
import {DataGrid}  from '@material-ui/data-grid';
import { Button } from "@material-ui/core";
import {Link} from "@material-ui/core";
import axios from "axios";
import axiosInstance from "./axios";


const columns = [
    {field:'name',headerName:'Name',width:300},
    {field:'price',headerName:'Price',width:300},
    {field:'description',headerName:'Description',width:300},


]

class RestaurantFood extends React.Component{

    constructor(){
        super();
        console.log(localStorage.getItem("RESTAURANT"));
        this.state = {
            foods:[]
        }
        {this.getFoods()};
    }

    getFoods(){
        axiosInstance
        .get("/restaurant/" + localStorage.getItem("RESTAURANT"))
        .then(response =>{
            const val = response.data

            this.setState({foods:val});
            console.log(val)
            console.log(this.state.foods)
        })
        .catch(error =>{
            console.log(error);
        })
    }

    
    addToShoppingCart(){


            let boughtFood = localStorage.getItem("TOBUY")
            let userr = localStorage.getItem("USER_ID")

            console.log("tobuy : " + boughtFood)
            console.log("user_id : " + userr)

            axiosInstance.post("/food/" + userr + "/" + boughtFood)
            .then(console.log("ok add to order"))
            .catch(error => {
                console.log(error)
            })


    }


    render(){
        
        return(

            <div>
                <Sidemenu></Sidemenu>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                    <div style={{ display: 'flex', height: 600,width:1750 }}>
                        <div style={{ flexGrow: 5 }}>
                        <DataGrid rows={this.state.foods} columns={columns} pageSize={20} 
                        onRowSelected={(e => localStorage.setItem("TOBUY",e.data.name))}/>
                        </div>
                    </div>
                </div>



                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
                    <Button
                            onClick={this.addToShoppingCart}
                            type="submit"
                            variant="contained"
                            color="inherit" >
                        Buy
                    </Button>
                </div>


            </div>

            
        )
        
    }

}

export default RestaurantFood;