import React from "react";
import Sidemenu from './Menu';
import { DataGrid } from '@material-ui/data-grid';
import { Button } from "@material-ui/core";
import {Link} from "@material-ui/core";
import axios from "axios";
import axiosInstance from "./axios";


const columns = [
    {field:'location',headerName:'Location',width:700},
    {field:'price',headerName:'Price',width:300},
    {field:'departure',headerName:'Departure',width:300},
    {field:'arrival',headerName:'Arrival',width:300},
]


class OnTheWay extends React.Component{

    constructor(){
        super();

        this.state = {
            transport:[],
            id:0,
            location:"",
            price:0,
            departure:"",
            arrival:""
        }



        axiosInstance
        .get("/transport/usertransport/" + localStorage.getItem("USER_ID"))
        .then( 
            response =>{

                const val = response.data

                this.setState({transport:val});
                console.log(val);
                console.log(val[0][0])
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

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center','margin-top':'200px'}}>
                    <div style={{ display: 'flex',justifyContent:'center', alignItems:'center', height: 170,width:1750 }}>
                     
                            <DataGrid 
                            autoPageSize="true"
                            hideFooterPagination="true"
                            hideFooterRowCount="true"
                            hideFooterSelectedRowCount="true"
                            pageSize={5} 
                            rows={this.state.transport} 
                            columns={columns} />
                       
                    </div>
                </div>
            </div>
        )
    }

}

export default OnTheWay;