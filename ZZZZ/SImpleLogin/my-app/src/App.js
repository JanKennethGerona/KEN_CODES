import React, { useState, useEffect } from 'react';
import {
  AppBar,
  Toolbar,
  IconButton,
  Typography,
  Box,
  TextField,
  Button,
  Paper,
  Avatar,
  Checkbox,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
  Fab,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
} from '@mui/material';
import LogoutIcon from '@mui/icons-material/Logout';
import AddIcon from '@mui/icons-material/Add';
import CloseIcon from '@mui/icons-material/Close';

// ...all imports remain unchanged

function Dashboard({ username, onLogout }) {
  const [tasks, setTasks] = useState(() => {
    const saved = localStorage.getItem(`tasks_${username}`);
    return saved ? JSON.parse(saved) : [];
  });
  const [searchTerm, setSearchTerm] = useState('');
  const [addOpen, setAddOpen] = useState(false);
  const [welcomeOpen, setWelcomeOpen] = useState(true);

  // Fields for new task
  const [newTask, setNewTask] = useState('');
  const [newStatus, setNewStatus] = useState('To Do');
  const [newPriority, setNewPriority] = useState('Normal');
  const [newAssignee, setNewAssignee] = useState('');
  const [newDueDate, setNewDueDate] = useState(''); // [DueDate]
  const [editingIndex, setEditingIndex] = useState(null);

  useEffect(() => {
    localStorage.setItem(`tasks_${username}`, JSON.stringify(tasks));
  }, [tasks, username]);

  const handleAddTask = () => {
    if (newTask.trim() === '') return;
    const taskData = {
      text: newTask,
      status: newStatus,
      priority: newPriority,
      assignee: newAssignee,
      dueDate: newDueDate, // [DueDate]
      done: false,
    };
    if (editingIndex !== null) {
      const updatedTasks = [...tasks];
      updatedTasks[editingIndex] = taskData;
      setTasks(updatedTasks);
      setEditingIndex(null);
    } else {
      setTasks([...tasks, taskData]);
    }
    setNewTask('');
    setNewStatus('To Do');
    setNewPriority('Normal');
    setNewAssignee('');
    setNewDueDate(''); // [DueDate]
    setAddOpen(false);
  };

  const handleStatusChange = (idx, status) => {
    const updated = [...tasks];
    updated[idx].status = status;
    setTasks(updated);
  };

  const handleCheckboxChange = (idx) => {
    const updated = [...tasks];
    updated[idx].done = !updated[idx].done;
    setTasks(updated);
  };

  const handleDelete = (idx) => {
    const updated = tasks.filter((_, i) => i !== idx);
    setTasks(updated);
  };

  const handleEdit = (idx) => {
    const task = tasks[idx];
    setNewTask(task.text);
    setNewStatus(task.status);
    setNewPriority(task.priority);
    setNewAssignee(task.assignee);
    setNewDueDate(task.dueDate || ''); // [DueDate]
    setEditingIndex(idx);
    setAddOpen(true);
  };

  const filteredTasks = tasks
    .filter(task => task.text.toLowerCase().includes(searchTerm.toLowerCase()))
    .sort((a, b) => {
      if (a.done === b.done) return 0;
      return a.done ? 1 : -1;
    });

  const assignees = ['kenet', 'warlter', 'yahyah'];

  return (
    <Box sx={{ minHeight: '100vh', background: 'rgba(0,0,0,0.7)' }}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            Dashboard
          </Typography>
          <IconButton color="inherit" onClick={onLogout}>
            <LogoutIcon />
          </IconButton>
        </Toolbar>
      </AppBar>

      <Dialog open={welcomeOpen} onClose={() => setWelcomeOpen(false)}>
        <DialogContent dividers sx={{ alignContent: 'center', textAlign: 'center', height: 250, width: 500 }}>
          <Avatar
            alt="User"
            src="https://via.placeholder.com/100"
            sx={{ width: 100, height: 100, margin: 'auto', mb: 2 }}
          />
          <Typography variant="h6" sx={{ mb: 2 }}>
            Welcome, {username}!
          </Typography>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setWelcomeOpen(false)} color="primary">
            Close
          </Button>
        </DialogActions>
      </Dialog>

      <Box sx={{ display: 'flex', alignItems: 'center', justifyContent: 'center', minHeight: 'calc(100vh - 64px)', p: 2 }}>
        <Paper sx={{ p: 3, width: '100%', height: '100%' }}>
          <Typography variant="h5" gutterBottom align="center">
            Your Tasks
          </Typography>
          <Typography variant="subtitle1" align="center" sx={{ mb: 2 }}>
            Welcome, {username}!
          </Typography>
          <TableContainer>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>Done</TableCell>
                  <TableCell>Assignee</TableCell>
                  <TableCell>Priority</TableCell>
                  <TableCell>Task</TableCell>
                  <TableCell>Due Date</TableCell>
                  <TableCell>Change Status</TableCell>
                  <TableCell>Delete</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {filteredTasks.map((task, idx) => {
                  const originalIdx = tasks.indexOf(task);
                  return (
                    <TableRow
                      key={idx}
                      sx={{
                        backgroundColor: task.done
                          ? '#e0e0e0'
                          : task.priority === 'High'
                          ? '#ffcccc'
                          : task.priority === 'Normal'
                          ? '#fff9c4'
                          : task.priority === 'Low'
                          ? '#c8e6c9'
                          : 'inherit',
                      }}
                    >
                      <TableCell>
                        <Checkbox
                          checked={task.done}
                          onChange={() => handleCheckboxChange(originalIdx)}
                        />
                      </TableCell>
                      <TableCell>{task.assignee}</TableCell>
                      <TableCell>{task.priority}</TableCell>
                      <TableCell style={{ textDecoration: task.done ? 'line-through' : 'none' }}>
                        {task.text}
                      </TableCell>
                      <TableCell>{task.dueDate ? new Date(task.dueDate).toLocaleDateString() : '—'}</TableCell>
                      <TableCell>
                        <Select
                          value={task.status}
                          size="small"
                          onChange={e => handleStatusChange(originalIdx, e.target.value)}
                        >
                          <MenuItem value="To Do">To Do</MenuItem>
                          <MenuItem value="Doing">Doing</MenuItem>
                          <MenuItem value="Done">Done</MenuItem>
                        </Select>
                      </TableCell>
                      <TableCell>
                        <Button size="small" color="error" onClick={() => handleDelete(originalIdx)}>
                          Delete
                        </Button>
                        <Button size="small" onClick={() => handleEdit(originalIdx)}>
                          Edit
                        </Button>
                      </TableCell>
                    </TableRow>
                  );
                })}
                {filteredTasks.length === 0 && (
                  <TableRow>
                    <TableCell colSpan={8} align="center" sx={{ color: '#888' }}>
                      No tasks found.
                    </TableCell>
                  </TableRow>
                )}
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      </Box>

      <Fab
        color="primary"
        aria-label="add"
        sx={{ position: 'fixed', bottom: 32, right: 32, zIndex: 1000 }}
        onClick={() => setAddOpen(true)}
      >
        <AddIcon />
      </Fab>

      <Dialog open={addOpen} onClose={() => setAddOpen(false)}>
        <DialogTitle>{editingIndex !== null ? 'Edit Task' : 'Add Task'}</DialogTitle>
        <DialogContent sx={{ minWidth: 300 }}>
          <TextField
            label="Task Name"
            value={newTask}
            onChange={e => setNewTask(e.target.value)}
            fullWidth
            margin="normal"
          />
          {/* [DueDate] */}
          <TextField
            label="Due Date"
            type="date"
            fullWidth
            margin="normal"
            value={newDueDate}
            onChange={e => setNewDueDate(e.target.value)}
            InputLabelProps={{ shrink: true }}
          />
          <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, my: 2 }}>
            <FormControl fullWidth margin="normal" size="small">
              <InputLabel>Status</InputLabel>
              <Select
                value={newStatus}
                label="Status"
                onChange={e => setNewStatus(e.target.value)}
              >
                <MenuItem value="To Do">To Do</MenuItem>
                <MenuItem value="Doing">Doing</MenuItem>
                <MenuItem value="Done">Done</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth margin="normal" size="small">
              <InputLabel>Priority</InputLabel>
              <Select
                value={newPriority}
                label="Priority"
                onChange={e => setNewPriority(e.target.value)}
              >
                <MenuItem value="Low">Low</MenuItem>
                <MenuItem value="Normal">Normal</MenuItem>
                <MenuItem value="High">High</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth margin="normal" size="small">
              <InputLabel>Assignee</InputLabel>
              <Select
                value={newAssignee}
                label="Assignee"
                onChange={e => setNewAssignee(e.target.value)}
              >
                {assignees.map(assignee => (
                  <MenuItem key={assignee} value={assignee}>
                    {assignee}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            <Button
              variant="contained"
              color="primary"
              onClick={handleAddTask}
              sx={{ width: '100%', mt: 2 }}
            >
              {editingIndex !== null ? 'Update' : 'Add'} Task
            </Button>
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setAddOpen(false)} color="primary">
            Cancel
          </Button>
        </DialogActions>
      </Dialog>
    </Box>
  );
}

// App component remains unchanged


function App() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const [showRegister, setShowRegister] = useState(false);
  const [regUsername, setRegUsername] = useState('');
  const [regPassword, setRegPassword] = useState('');
  const [regMessage, setRegMessage] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = async (e) => {
    e.preventDefault();
    setMessage('');
    try {
      const res = await fetch('http://localhost:5000/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
      });
      const data = await res.json();
      if (data.success) {
        setMessage('');
        setLoggedIn(true);
      } else {
        setMessage('Invalid username or password.');
      }
    } catch (err) {
      setMessage('Error connecting to server.');
    }
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    setRegMessage('');
    try {
      const res = await fetch('http://localhost:5000/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: regUsername, password: regPassword }),
      });
      const data = await res.json();
      if (data.success) {
        setRegMessage('Registration successful!');
        setRegUsername('');
        setRegPassword('');
      } else {
        setRegMessage('Registration failed.');
      }
    } catch (err) {
      setRegMessage('Error connecting to server.');
    }
  };

  const handleLogout = () => {
    setLoggedIn(false);
    setUsername('');
    setPassword('');
    setMessage('');
  };

  return loggedIn ? (
    <Dashboard username={username} onLogout={handleLogout} />
  ) : (
    <Box
      sx={{
        height: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#f5f5f5',
      }}
    >
      <Paper elevation={3} sx={{ padding: 4, minWidth: 300 }}>
        {!showRegister ? (
          <>
            <Typography variant="h5" gutterBottom>
              Login
            </Typography>
            <form onSubmit={handleLogin}>
              <TextField
                label="Username"
                variant="outlined"
                fullWidth
                margin="normal"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <TextField
                label="Password"
                type="password"
                variant="outlined"
                fullWidth
                margin="normal"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <Button
                type="submit"
                variant="contained"
                color="primary"
                fullWidth
                sx={{ mt: 2 }}
              >
                Login
              </Button>
            </form>
            {message && (
              <Typography color={message === 'Login successful!' ? 'success.main' : 'error'} sx={{ mt: 2 }}>
                {message}
              </Typography>
            )}
            <Button
              variant="text"
              color="secondary"
              fullWidth
              sx={{ mt: 2 }}
              onClick={() => setShowRegister(true)}
            >
              Register
            </Button>
          </>
        ) : (
          <>
            <Typography variant="h6" gutterBottom>
              Register
            </Typography>
            <form onSubmit={handleRegister}>
              <TextField
                label="Username"
                variant="outlined"
                fullWidth
                margin="normal"
                value={regUsername}
                onChange={(e) => setRegUsername(e.target.value)}
              />
              <TextField
                label="Password"
                type="password"
                variant="outlined"
                fullWidth
                margin="normal"
                value={regPassword}
                onChange={(e) => setRegPassword(e.target.value)}
              />
              <Button
                type="submit"
                variant="contained"
                color="secondary"
                fullWidth
                sx={{ mt: 2 }}
              >
                Register
              </Button>
            </form>
            {regMessage && (
              <Typography color={regMessage === 'Registration successful!' ? 'success.main' : 'error'} sx={{ mt: 2 }}>
                {regMessage}
              </Typography>
            )}
            <Button
              variant="text"
              color="primary"
              fullWidth
              sx={{ mt: 2 }}
              onClick={() => setShowRegister(false)}
            >
              Back to Login
            </Button>
          </>
        )}
      </Paper>
    </Box>
  );
}

export default App;
