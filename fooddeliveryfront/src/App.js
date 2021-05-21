import logo from './logo.svg';
import './App.css';
import {

  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from "react-router-dom";
import Login from './Login';
import User from './User';
import Worker from './Worker';
import Admin from './Admin';
import UserOrder from './UserOrder';
import UserSearchFood from './UserSearchFood';
import OnTheWay from './OnTheWay';
import RestaurantFood from './RestaurantFood';
import Register from './Register';
import Verify from './Verify';
import AdminEditUsers from './AdminEditUsers';
import AdminEditRestaurants from './AdminEditRestaurants';
import AdminEditOffers from './AdminEditOffers';
<<<<<<< HEAD
import CardPayment from './CardPayment';
import Explore from './Explore';
import AdminViewTimestamps from './AdminViewTimestamps';
import WebSocket from './WebSocket';
import InviteAFriend from './InviteAFriend';
=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4


function App() {
  const defaultRoute = window.location.pathname === "/" ? <Redirect to="/login" /> : undefined;

  return (

    <Router>
      <Switch>
        <Route exact path="/login" component={Login} />
        <Route exact path="/admin" component={Admin} />
        <Route exact path="/user" component={User} />
        <Route exact path="/user/restaurantfood" component={RestaurantFood} />
        <Route exact path="/user/searchfood" component={UserSearchFood} />
        <Route exact path="/user/order" component={UserOrder} />
        <Route exact path="/user/ontheway" component={OnTheWay} />
        <Route exact path="/worker" component={Worker} />
        <Route exact path="/register" component={Register}/>
        <Route exact path="/register/verify" component={Verify}/>
        <Route exact path="/admin/users" component={AdminEditUsers}/>
        <Route exact path="/admin/restaurants" component={AdminEditRestaurants}/>
        <Route exact path="/admin/offers" component={AdminEditOffers}/>
<<<<<<< HEAD
        <Route exact path="/user/order/cardpayment" component={CardPayment}/>
        <Route exact path="/user/explore" component={Explore}/>
        <Route exact path="/admin/viewtimestamps" component={AdminViewTimestamps}/>
        <Route exact path="/notif" component={WebSocket}/>
        <Route exact path="/user/invite" component={InviteAFriend}/>
=======

>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
      </Switch>
      {defaultRoute}
    </Router>

  );
}

export default App;
