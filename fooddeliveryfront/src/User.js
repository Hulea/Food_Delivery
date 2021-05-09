import { Menu } from "@material-ui/core";
import {DataGrid}  from '@material-ui/data-grid';
import { Button } from "@material-ui/core";
import React from "react";
import axiosInstance from "./axios";
import Sidemenu from "./Menu";
import {Link} from "@material-ui/core";



const columns = [
    {field:'name',headerName:'Restaurant',width:300},
    {field:'location',headerName:'Location',width:300},
]


class User extends React.Component{

    constructor(){
        super();
        this.state = {
            restaurants:[]
        }

        axiosInstance
        .get("/restaurant/user")
        .then(response =>{
            const val = response.data

            this.setState({restaurants:val});
            console.log(val)
        })
        .catch(error =>{
            console.log(error);
        })
    }


   

  

    render(){
        return(

        <div>
            <Sidemenu></Sidemenu>
           
            <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                <div style={{ display: 'flex', height: 600,width:1750 }}>
                    <div style={{ flexGrow: 5 }}>
                    <DataGrid rows={this.state.restaurants} columns={columns} pageSize={20} 
                    onRowSelected={(e => localStorage.setItem("RESTAURANT",e.data.name))}/>
                    </div>
                </div>
            </div>

            

            <Link href = "user/restaurantfood">
                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
                <Button
                        type="submit"
                        variant="contained"
                        color="inherit" >
                    View
                </Button>
                </div>
            </Link>


        </div>
 

        )
    }

}

export default User;