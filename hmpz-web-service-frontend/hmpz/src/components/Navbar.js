import React, { useState, useEffect, useMemo } from 'react'
import PropTypes from 'prop-types'
import useMediaQuery from '@mui/material/useMediaQuery';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import WebFont from 'webfontloader';
import CssBaseline from '@mui/material/CssBaseline';
import Paper from '@mui/material/Paper';
import { styled, alpha } from '@mui/material/styles';
import Divider from '@mui/material/Divider';
import Drawer from '@mui/material/Drawer';
import AccountCircle from '@mui/icons-material/AccountCircle';
import IconButton from '@mui/material/IconButton';
import MoveToInboxIcon from '@mui/icons-material/MoveToInbox';
import List from '@mui/material/List';
import InputBase from '@mui/material/InputBase';
import ListItem from '@mui/material/ListItem';
import Badge from '@mui/material/Badge';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import MailIcon from '@mui/icons-material/Mail';
import MenuIcon from '@mui/icons-material/Menu';
import Toolbar from '@mui/material/Toolbar';
import SearchIcon from '@mui/icons-material/Search';
import Typography from '@mui/material/Typography';
import Avatar from '@mui/material/Avatar';
import { Stack } from '@mui/material';
import { Link } from 'react-router-dom';
import HomeIcon from '@mui/icons-material/Home';
import AuthService from '../services/auth.service';
import Login from './Login';
import { borderRight } from '@mui/system';
import WhatshotIcon from '@mui/icons-material/Whatshot';
import AccountBoxIcon from '@mui/icons-material/AccountBox';
import BookmarkAddedIcon from '@mui/icons-material/BookmarkAdded';
import LogoutIcon from '@mui/icons-material/Logout';

function Navbar(props) {
  const { window } = props;
  const [mobileOpen, setMobileOpen] = useState(false);
  const [user, setUser] = useState();

  useEffect(() => {
    WebFont.load({
      google: {
        families: ['Droid Sans', 'Rajdhani']
      }
    });
   }, []);

  useEffect(() => {
    const loggedInUser = localStorage.getItem("user");
    if (loggedInUser) {
      const foundUser = JSON.parse(loggedInUser);
      setUser(foundUser);
    }
  }, []);

  const logout = () => {
    AuthService.logout();
    refreshPage();
  }
  const refreshPage = () => {
    window.location.reload(false);
  }
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };
  const links = [
    {
      title: "Strona Główna",
      link: "/",
      icon: <HomeIcon color="success" sx={{ fontSize: 40 }} />
    },
    {
      title: "Trend",
      link: "/trends",
      icon: <WhatshotIcon color="success" sx={{ fontSize: 40 }} />
    },
    {
      title: "Profil",
      link: "/profile",
      icon: <AccountBoxIcon color="success" sx={{ fontSize: 40 }} />
    },
    {
      title: "Zapisane",
      link: "/save",
      icon: <BookmarkAddedIcon color="success" sx={{ fontSize: 40 }} />
    },
    {
      title: "Wyloguj",
      link: "",
      islogout: true,
      icon: <LogoutIcon color="success" sx={{ fontSize: 40 }} />
    }
  ]
  const Item = styled(Paper)(() => ({
    textAlign: 'center',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  }));

  const drawer = (
    <div>
      <Toolbar />
      <Stack>
        <Item >
          <Avatar variant="rounded" sx={{ width: 185, height: 185 }} alt="Remy Sharp" src="https://images.unsplash.com/photo-1580489944761-15a19d654956?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=922&q=80"/>
        </Item>
        <Item >
          <Typography padding="15px" fontFamily='Rajdhani' variant="h5" component="div" letterSpacing="0.7px" >
             @{user ? user.username : null}
          </Typography>
        </Item>

      </Stack>
      <Divider />
      <List>
        {links.map((item) => (
          <ListItem sx={{}} button key={item.title} onClick={item.islogout ? logout : null} component={Link} to={item.link}>
            <ListItemIcon >
              {item.icon}
            </ListItemIcon>
            <ListItemText primary={item.title} />
          </ListItem>
        ))}

        {/* <ListItem disablePadding onClick={logout} component={Link} to="/">
          <ListItemButton>
            <ListItemIcon>
              <MoveToInboxIcon />
            </ListItemIcon>
            <ListItemText primary={"Wyloguj"} />
          </ListItemButton>
        </ListItem> */}
      </List>
    </div>
  );

  const container = window !== undefined ? () => window().document.body : undefined;

  const Search = styled('div')(({ theme }) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: alpha(theme.palette.common.white, 0.15),
    '&:hover': {
      backgroundColor: alpha(theme.palette.common.white, 0.25),
    },
    marginRight: theme.spacing(2),
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing(3),
      width: 'auto',
    },
  }));

  const SearchIconWrapper = styled('div')(({ theme }) => ({
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  }));

  const StyledInputBase = styled(InputBase)(({ theme }) => ({
    color: 'inherit',
    '& .MuiInputBase-input': {
      padding: theme.spacing(1, 1, 1, 0),
      // vertical padding + font size from searchIcon
      paddingLeft: `calc(1em + ${theme.spacing(4)})`,
      transition: theme.transitions.create('width'),
      width: '100%',
      [theme.breakpoints.up('md')]: {
        width: '20ch',
      },
    },
  }));
  //rgb(35, 42, 46) post 
  //rgba(35, 42, 46, 0.95) appbar

  //rgb(162, 168, 171)
  //bg rgb(35, 42, 46)
  //box-shadow:rgb(48 62 71) 1px 0px 0px

  //icon rgb(74, 93, 105)

  //bod bg rgb(20, 28, 35)

  //text 1

  //rgb(68, 165, 116)

  ////rgb(203, 204, 210)
  return (
    <>
      <AppBar position="fixed" color="background" sx={{
        width: { sm: `calc(100% - ${props.drawerWidth}px)` },
        ml: { sm: `${props.drawerWidth}px` },
      }}>

        <Toolbar >
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="start"
            onClick={handleDrawerToggle}
            sx={{ mr: 2, display: { sm: 'none' } }}
          >
            <MenuIcon />
          </IconButton>
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{ display: { xs: 'none', sm: 'block' } }}
          >
            HMPZ
          </Typography>
          <Search>
            <SearchIconWrapper>
              <SearchIcon />
            </SearchIconWrapper>
            <StyledInputBase
              placeholder="Search…"
              inputProps={{ 'aria-label': 'search' }}
            />
          </Search>
          <Box sx={{ flexGrow: 1 }} />
          <Box sx={{ display: { xs: 'none', md: 'flex' } }}>
            <IconButton size="large" aria-label="show 4 new mails" color="inherit">
              <Badge badgeContent={4} color="error">
                <MailIcon />
              </Badge>
            </IconButton>
            <IconButton
              size="large"
              edge="end"
              aria-label="account of current user"
              aria-haspopup="true"
              color="inherit"
            >
              <AccountCircle />
            </IconButton>
          </Box>
        </Toolbar>
      </AppBar>
      <Box
        component="nav"

        sx={{ width: { sm: props.drawerWidth }, flexShrink: { sm: 0 } }}
        aria-label="mailbox folders">
        <Drawer
          container={container}
          variant="temporary"
          open={mobileOpen}
          onClose={handleDrawerToggle}
          ModalProps={{
            keepMounted: true,
          }}
          sx={{
            display: { xs: 'block', sm: 'none' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: props.drawerWidth },
          }}>
          {user ? drawer : <Login />}
        </Drawer>

        <Drawer
          variant="permanent"
          sx={{
            display: { xs: 'none', sm: 'block' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: props.drawerWidth },
          }}
          open>
          {user ? drawer : <Login />}
        </Drawer>
      </Box>
    </>)
}

Navbar.propTypes = {}

export default Navbar
