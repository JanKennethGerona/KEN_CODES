import React from 'react';
import { Box, Typography, Paper, Avatar, Button } from '@mui/material';

function Dashboard({ username, onLogout }) {
  return (
    <Box
      sx={{
        height: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#f5f5f5',
      }}
    >
      <Paper elevation={3} sx={{ padding: 4, minWidth: 350 }}>
        <Typography variant="h4" gutterBottom>
          Dashboard
        </Typography>
        <Avatar
          alt="User"
          src="https://via.placeholder.com/100"
          sx={{ width: 100, height: 100, margin: 'auto', mb: 2 }}
        />
        <Typography variant="h6" align="center" sx={{ mb: 2 }}>
          Welcome, {username}!
        </Typography>
        <Button
          variant="contained"
          color="secondary"
          fullWidth
          onClick={onLogout}
        >
          Logout
        </Button>
      </Paper>
    </Box>
  );
}

export default Dashboard;