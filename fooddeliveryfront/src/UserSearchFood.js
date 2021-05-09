import React from "react";
import Sidemenu from './Menu';


class UserSearchFood extends React.Component{

    constructor(){
        super();
    }

    render(){
        return(
            <div>
                <Sidemenu></Sidemenu>

                <div style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>

                    <h1>Welcome User</h1>

                </div>
            </div>
        )
    }

}

export default UserSearchFood;