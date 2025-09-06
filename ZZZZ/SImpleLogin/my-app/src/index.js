import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Dashboard from './dashboard';
import { ThemeProvider, CssBaseline, createTheme } from '@mui/material';
import { BrowserRouter, Routes, Route, useLocation, useNavigate } from 'react-router-dom';

const theme = createTheme();

function DashboardWrapper() {
  const location = useLocation();
  const navigate = useNavigate();
  const username = location.state?.username || 'User';
  const handleLogout = () => navigate('/');
  return <Dashboard username={username} onLogout={handleLogout} />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<App />} />
          <Route path="/dashboard" element={<DashboardWrapper />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  </React.StrictMode>
);
