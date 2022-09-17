import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

export const BASE_API_URL = 'http://eventdriven.ddns.net:8080';

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
