import React, {} from 'react'
import Post from "./Post";


const MainContent = (props) => {
  const content = props.content;
  const user = props.user;
  const listItems = content.map((post) =>
  <Post
    key={post.postId}
    id={post.postId}
    post={post} 
    user ={user}/>
);

  return (
    <div className='sss'>
      {listItems}
    </div>
  )
}

export default MainContent
