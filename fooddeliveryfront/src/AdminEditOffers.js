import {Menu, TextField} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import React from "react";
import axiosInstance from "./axios";
import Sidemenu from "./MenuAdmin";
import {Link} from "@material-ui/core";
import Container from "@material-ui/core/Container";

const columns = [
    {field:'name',headerName:'Name',width:300},
    {field:'location',headerName:'Location',width:300},
    {field:'food',headerName:'Food',width:300},
]


class AdminEditOffers extends React.Component{


    constructor(){

        super();

        this.state = {
            offers:[]
        }

        axiosInstance
        .get("/offer/admin")
        .then(
            response =>{
                const val = response.data

                this.setState({offers:val});

                console.log(val);
            }
        )
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
                            <DataGrid rows={this.state.orders} columns={columns} pageSize={20} />
                        </div>
                    </div>
                </div>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'20px'}}>
                
                <div style = {{'margin-right':'20px'}}>
                    <Button
                            variant="contained"
                            color="primary" >
                        Add
                    </Button>
                </div>

                <div style = {{'margin-right':'20px'}}>
                    <Button
                            variant="contained"
                            color="inherit" >
                        Edit
                    </Button>
                </div>

                <div style = {{'margin-right':'20px'}}>
                    <Button
                            variant="contained"
                            color="secondary" >
                        Delete
                    </Button>
                </div>

                </div>

            </div>
        )

    }

}

export default AdminEditOffers;