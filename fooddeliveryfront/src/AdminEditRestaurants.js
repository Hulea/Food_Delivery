import {Menu, TextField} from '@material-ui/core';
import {DataGrid} from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import React from "react";
import axiosInstance from "./axios";
import Sidemenu from "./MenuAdmin";
import {Link} from "@material-ui/core";
import Container from "@material-ui/core/Container";
<<<<<<< HEAD
import saveAs from "file-saver";
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4

const columns = [
    {field:'id',headerName:'Id',width:300},
    {field:'name',headerName:'Name',width:300},
    {field:'location',headerName:'Location',width:300},
<<<<<<< HEAD
=======
    {field:'food',headerName:'Food',width:300},
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
]


class AdminEditRestaurants extends React.Component{

    constructor(){
        super();

        this.state = {
            restaurants:[],
            id:0,
            name:"",
            location:"",
            food:[]

        }

        this.onSubmitF = this.onSubmitF.bind(this)
        this.onSubmitDelete = this.onSubmitDelete.bind(this)
        this.onSubmitEdit = this.onSubmitEdit.bind(this)

        axiosInstance
        .get("/restaurant/user")
        .then(
            response => {
                const val = response.data

                this.setState({restaurants:val});

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
    let newRestaurant = {
        name:this.state.name,
        location:this.state.location,
        food:this.state.food
    }

    console.log(newRestaurant)

    axiosInstance.post("/restaurant/add",newRestaurant)
    .then(console.log("ok"))
    .catch(error =>{
        console.log(error)
    })
}

onSubmitDelete(){

    let delRes = this.state.id


    console.log( delRes)

    axiosInstance.delete("/restaurant/delete/" + delRes)
    .then(console.log("ok del"))
    .catch(error =>{
        console.log(error)
    })

}


onSubmitEdit(){

    let newRestaurant2 = {
        id:this.state.id,
        name:this.state.name,
        location:this.state.location
    }

    console.log(newRestaurant2)

    axiosInstance.put("/restaurant/update",newRestaurant2)
    .then(console.log("ok update"))
    .catch(error => {
        console.log(error)
    })

}


<<<<<<< HEAD
onSubmitExport(){

     axiosInstance
     .get("/restaurant/xml")
     .then((res) => {


        let blob = new Blob([res.data], { type: "text/xml;charset=utf-8" });

        saveAs(blob, Math.floor(Math.random()*1000).toString() +".XML");
        console.log(blob);
      })
     .catch(error => {
        console.log(error)
    })


}



=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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
                            onChange = {this.handleInput}
                            name="id" />
<<<<<<< HEAD
=======
                       
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                        </div>

                        <div >
                            <TextField
                            style={{'margin-right':'70px'}}
                            id="standard-basic"
                            label="Name"
                            onChange = {this.handleInput}
                            name="name" />
<<<<<<< HEAD

                        </div>

=======
                       
                        </div>
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                        <div>
                            <TextField
                            style={{'margin-right':'70px'}}
                            id="standard-basic"
                            label="Location"
<<<<<<< HEAD
                            onChange = {this.handleInput}
                            name="location"/>
                        </div>

=======
                            onChange = {this.handleInput} 
                            name="location"/>
                           
                        </div>
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                        <div>
                            <TextField
                            style={{'margin-right':'70px'}}
                            id="standard-basic"
                            label="Food List"
                            onChange = {this.handleInput}
                            name="food" />
<<<<<<< HEAD
=======
                           
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
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

<<<<<<< HEAD

                    <div style = {{'margin-right':'20px'}}>
                        <Button
                                onClick={this.onSubmitExport}
                                type = "submit"
                                variant="contained"
                                color="primary" >
                            Export as XML
                        </Button>
                    </div>

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
                    </div>



                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                    <div style={{ display: 'flex', height: 600,width:1750 }}>
                        <div style={{ flexGrow: 5 }}>
                            <DataGrid rows={this.state.restaurants} columns={columns} pageSize={20} />
                        </div>
                    </div>
                </div>


               

            </div>

        )

    }


}

export default AdminEditRestaurants;