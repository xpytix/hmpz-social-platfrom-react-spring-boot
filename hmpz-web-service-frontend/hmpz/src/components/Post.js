import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Divider from '@mui/material/Divider';
import Typography from '@mui/material/Typography';
import { Box } from '@mui/material';
import { Button, CardActionArea, CardActions } from '@mui/material';
import { styled, alpha } from '@mui/material/styles';
import Stack from '@mui/material/Stack';
import { customTheme } from '../App';
import CardHeader from '@mui/material/CardHeader';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import Skeleton from '@mui/material/Skeleton';
import FavoriteIcon from '@mui/icons-material/Favorite';
import MapsUgcIcon from '@mui/icons-material/MapsUgc';
import BookmarkAddIcon from '@mui/icons-material/BookmarkAdd';
import SettingsIcon from '@mui/icons-material/Settings';

const Item = styled(Button)(({ customTheme }) => ({
  backgroundColor: 'text.hint',
  color: 'palette.divider.main',
  width: '100%',
  textAlign: 'center',

}));

const Post = (props) => {
  const user = props.post.user;
  const { loading = false } = props;

  return (
    <Card className='card' sx={{ m: 4 }}>
     
     <CardHeader
       sx={{paddingBottom: 2}}
        avatar={
          loading ? (
            <Skeleton animation="wave" variant="circular" width={40} height={40} />
          ) : (
            <Avatar
              alt="Ted talk"
              src="https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1180&q=80"
            />
          )
        }
        action={
          loading ? null : (
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          )
        }
        title={
          loading ? (
            <Skeleton
              animation="wave"
              height={10}
              width="80%"
              style={{ marginBottom: 10 }}
            />
          ) : (
            <Typography sx={{color: 'rgba(0, 0, 0, 1)'}}>
            {user ? user.name : 'HMPZ' }
           </Typography>
          )
        }
        subheader={
          loading ? (
            <Skeleton animation="wave" height={10} width="40%" />
          ) : (
            <Typography sx={{color: 'rgba(0, 0, 0, 0.54)'}}>
            5 min ago
           </Typography>
          )
        }
      />

        <CardActionArea>

          <CardContent sx={{paddingTop: 0}}>
            <Typography gutterBottom variant="subtitle2" component="div">
              {props.post.name}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {props.post.description}
            </Typography>
          </CardContent>

        </CardActionArea>
      


      <Divider backgroundColor="palette.divider.main" />
      <Stack
        direction="row"
        display='flex'
        justifyContent='center'
        alignItems='center'
        backgroundColor="success"
      >
        <Item backgroundColor="success">
          <FavoriteIcon color="success" />
          <Typography color="secondary" variant="h5" >
            {props.post.voteCount}
          </Typography>
        </Item>
        <Item>
          <Typography color="secondary" variant="h5" >
            <MapsUgcIcon color="success" />
            {props.post.voteCount - 15}
          </Typography>
        </Item>
        <Item>
          <Typography color="secondary" variant="h5" >
            <BookmarkAddIcon color="success" />
            {12}
          </Typography>
        </Item>
      </Stack>
    </Card>
  );
}
export default Post;