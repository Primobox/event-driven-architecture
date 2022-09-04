import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

export const API_BASE_URL = "http://event-driven-architecture.herokuapp.com/backoffice";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
