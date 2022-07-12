import React from 'react'
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import {Routes, Route} from 'react-router-dom'
import Main from './Main';
import Login from './Login';
import  Profile  from './Profile';

const Hero = (props) =>
{
   return (
   
        <Box
        component="main"
        sx={{ flexGrow: 1, p: 3, width: { sm: `calc(100% - ${props.drawerWidth}px)` } }}>

        <Toolbar />
        <Routes>
          <Route exact path='/' element={<Main/>}/>
          <Route exact path='/trends' element={<Main trend={true}/>}/>
          <Route exact path='/profile' element={<Profile/>}/>

        </Routes>
      </Box>

  )
}

export default Hero
