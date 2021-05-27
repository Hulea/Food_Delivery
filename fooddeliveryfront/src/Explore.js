import React from "react";
import axiosInstance from "./axios";
import Sidemenu from './Menu';
import { Menu } from "@material-ui/core";
import {DataGrid}  from '@material-ui/data-grid';
import {Button} from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import { Component } from 'react';
import { Map, GoogleApiWrapper, InfoWindow, Marker } from 'google-maps-react';



const mapStyles = {
  width: '100%',
  height: '100%'
};


export class Explore extends React.Component{

    state = {
        showingInfoWindow: false,
        activeMarker: {},
        selectedPlace: {}
    };


    onMarkerClick = (props, marker, e) =>
        this.setState({
        selectedPlace: props,
        activeMarker: marker,
        showingInfoWindow: true
        });

    onClose = props => {
        if (this.state.showingInfoWindow) {
        this.setState({
            showingInfoWindow: false,
            activeMarker: null
        });
        }
    };


    constructor(){
        super();

        this.state = {}

    }

    render(){
        return(
            <div>
                <Sidemenu></Sidemenu>

                <Map
                    google={this.props.google}
                    zoom={18}
                    style={mapStyles}
                    initialCenter={
                    {
                        lat: 46.07058,
                        lng:  23.55809
                    }
                }>

                <Marker
                    //onClick={this.onMarkerClick}
                    name={'Panini'}
                    position={{lat:46.07058,lng:23.55809}}
                />

                <Marker
                    onClick={this.onMarkerClick}
                    position={{lat:46.07004,lng:23.54696}}
                />

                <Marker
                    onClick={this.onMarkerClick}
                    position={{lat:46.06960,lng:23.57798}}
                />

            </Map>


            </div>
        )
    }

}


export default GoogleApiWrapper({
    apiKey: 'inser api key here'
  })(Explore);
