import * as React from 'react';
import Box from '@mui/material/Box';
import Navbar from './components/Navbar';
import Hero from './components/Hero';
import useMediaQuery from '@mui/material/useMediaQuery';
import './components/css/Navbar.css'
import { createTheme, ThemeProvider } from "@mui/material/styles";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
const drawerWidth = 290;



export const customTheme = createTheme({
  palette: {
    type: 'dark',
    primary: {
      main: '#141c23',
      contrastText: '#44a574',
      dark: '#0e1318',
    },
    secondary: {
      main: '#44a574',
      contrastText: '#cbccd2',
    },
    background: {
      paper: '#232a2e',
      default: '#141c23',
    },
    text: {
      secondary: '#ffffff',
      primary: '#ffffff',
      disabled: '#ffffff',
      hint: 'rgba(255,255,255,0.38)',
    },
    divider: 'rgba(68,165,116,0.3)',
    success: {
      main: 'rgba(68,165,116)',
    },
  },
});

function App(props) {


  return (
    <Router>
          <ThemeProvider theme={customTheme}>
      <Box sx={{ display: 'flex' }}>
        <Navbar className='listItem' drawerWidth ={drawerWidth} />
        <Hero drawerWidth ={drawerWidth} />
      </Box>
      </ThemeProvider>
    </Router>
  );
}


export default App;
