import React from "react";
import Sidemenu2 from"./MenuAdmin";


class Admin extends React.Component{

    constructor(){
        super();
    }

    render(){
        return(
            <div>

            <Sidemenu2></Sidemenu2>

            <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                <h1>Welcome Admin</h1>
            </div>
            </div>
        )
    }

}

export default Admin;