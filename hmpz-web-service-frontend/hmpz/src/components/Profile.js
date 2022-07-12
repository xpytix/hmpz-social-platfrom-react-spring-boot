import React from "react";
import PropTypes from 'prop-types';
import CircularProgress from '@mui/material/CircularProgress';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import AuthService from "../services/auth.service";
import CountUp from 'react-countup';
import { Container } from "@mui/material";

const Profile = (props) => {
  const currentUser = AuthService.getCurrentUser();

  const [progress, setProgress] = React.useState(10);

  return(
    <>
    <Container maxWidth="md">
    {/* <CountUp end={145} />
    <Card className='card' sx={{ m: 4 }}>
     

        <CardActionArea>

          <CardContent>
       
          <Box sx={{display:'flex', flexDirection:'row', justifyContent:'flex-end '}}>

           <Avatar variant="circle" sx={{width: '15px', height: '15px', marginRight: '5px', alignItems: 'baseline'  }} alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
  
          </Box>

          </CardContent>

        </CardActionArea>
      

    </Card> */}
    </Container>
    </>
  )
  
  

};
export default Profile;

