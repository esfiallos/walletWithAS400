import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [clientes, setClientes] = useState([])
  const [cargando, setCargando] = useState(true)
  const [error, setError] = useState(null)

  // 1. Obtenemos la URL de la variable de entorno. 
  // Si no existe (ej. corriendo en local sin .env), usa localhost por defecto.
  const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;


  useEffect(() => {
    fetch(`${API_BASE_URL}/clientes`)
      .then(response => response.json())
      .then(data => {
        setClientes(data)
        setCargando(false)
      })
      .catch(error => {
        console.error("Error conectando al AS400:", error)
        setError(error)
        setCargando(false)
      })
  }, [])

  return (
    <>
      {cargando && <div>Cargando...</div>}
      {error && <div>Error: {error.message}</div>}
      {!cargando && !error && (
        <div className="tarjetas-grid">
          {clientes.map(cliente => (
            <div key={cliente.id} className="tarjeta">
              {/* --- Elementos Superiores --- */}
              <div className="logo-banco">
                <span>🏦</span>
                <span>Banco XXXXXXXXX</span>
              </div>
              <div className="contactless-icon">
                ☎
              </div>

              <div className="chip">💳</div>
              
              <div className="saldo-container">
                <small className="saldo-label">Saldo Disponible</small>
                <p className="saldo">L. {cliente.saldo.toFixed(2)}</p>
              </div>

              <div className="info-bottom">
                <div>
                  <small style={{opacity: 0.7, display:'block', marginBottom:'2px'}}>TITULAR</small>
                  <span>{cliente.nombre}</span>
                </div>
                <div>
                  <small style={{opacity: 0.7, display:'block', marginBottom:'2px'}}>DESDE</small>
                  <span>{cliente.fechaRegistro}</span>
                </div>
              </div>

            </div>
          ))}
        </div>
      )}
    </>
  )
}

export default App