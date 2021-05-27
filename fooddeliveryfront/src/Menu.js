import React from 'react';
import clsx from 'clsx';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import CssBaseline from '@material-ui/core/CssBaseline';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import {Link} from "@material-ui/core";
import FastfoodIcon from '@material-ui/icons/Fastfood';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import DirectionsCarIcon from '@material-ui/icons/DirectionsCar';
import HomeIcon from '@material-ui/icons/Home';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import {Grid} from "@material-ui/core";
import ExploreIcon from '@material-ui/icons/Explore';
import axiosInstance from './axios';
import PersonAddIcon from '@material-ui/icons/PersonAdd';

const drawerWidth = 300;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },

  appBar: {
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    backgroundColor: "#0099ff"
  },

  appBarShift: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
    backgroundColor: "#0099ff",
  },
  drawerHeader: {
    display: 'flex',
    alignItems: 'center',
    padding: theme.spacing(0, 1),
    // necessary for content to be below app bar
    ...theme.mixins.toolbar,
    justifyContent: 'flex-end',
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    marginLeft: -drawerWidth,
  },
  contentShift: {
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginLeft: 0,
  },
}));





export default function PersistentDrawerLeft() {
  const classes = useStyles();
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };




  const logoutTimestamp = () =>{

    axiosInstance.post("user/timestamp/logout",localStorage.getItem("USER_ID"))
        .then(console.log("logout timestamp?"))
        .catch(error => {
            console.log(error)
        })

  };

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
        position="fixed"
        className={clsx(classes.appBar, {
          [classes.appBarShift]: open,
        })}
      >
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            className={clsx(classes.menuButton, open && classes.hide)}
          >
            <MenuIcon />
          </IconButton>
        
          
            <Grid container justify="flex-end" alignItems="flex-end">


              <Link href="/login">
                <IconButton style={{ bottom: 3, right: 3 }} onClick={logoutTimestamp}>
                  <ExitToAppIcon />
                </IconButton>
              </Link>

            </Grid>
         
          {/* <Typography variant="h6" noWrap>
            Menu
          </Typography> */}
        </Toolbar>
      </AppBar>
      <Drawer
        className={classes.drawer}
        variant="persistent"
        anchor="left"
        open={open}
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <div className={classes.drawerHeader}>
          <IconButton onClick={handleDrawerClose}>
            <MenuIcon style = {{ fill: "white"}} />
          </IconButton>
        </div>
        <Divider />
        <List>
        <Link href = "/user/searchfood">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <HomeIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="Home" style={{ color: '#FFFFFF' }}/>
            </ListItem>
        </Link>

        <Link href = "/user">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <FastfoodIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="Search food" style={{ color: '#FFFFFF' }}/>
            </ListItem>
        </Link>
        <Link href = "/user/order">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <ShoppingCartIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="Order" style={{ color: '#FFFFFF' }}/>
            </ListItem>
        </Link>
        <Link href = "/user/ontheway">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <DirectionsCarIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="On the way" color = "white" style={{ color: '#FFFFFF' }}/>
            </ListItem>
        </Link>
        
        <Link href = "/user/explore">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <ExploreIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="Explore" color = "white" style={{ color: '#FFFFFF' }}/>
              </ListItem>
        </Link>


        <Link href = "/user/invite">
            <ListItem>
                <ListItemAvatar>
                <Avatar>
                    <PersonAddIcon />
                </Avatar>
                </ListItemAvatar>
                <ListItemText primary="Invite a friend" color = "white" style={{ color: '#FFFFFF' }}/>
              </ListItem>
        </Link>


        </List>
      </Drawer>
      <main
        className={clsx(classes.content, {
          [classes.contentShift]: open,
        })}
      >
        <div className={classes.drawerHeader} />
      </main>
    </div>
  );
}