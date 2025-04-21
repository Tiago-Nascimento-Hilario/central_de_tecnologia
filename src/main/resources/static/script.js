function buscar() {
    const modelo = document.getElementById("modelo").value;
    const url = `http://localhost:8080/api/buscar?modelo=${encodeURIComponent(modelo)}`;
  
    fetch(url)
      .then(res => res.json())
      .then(data => {
        const resultadoDiv = document.getElementById("resultado");
        resultadoDiv.innerHTML = "";
  
        if (data.length === 0) {
          resultadoDiv.innerHTML = "<p>Nenhum modelo encontrado.</p>";
          return;
        }
  
        data.forEach(item => {
          resultadoDiv.innerHTML += `
            <div class="card">
              <p><strong>Modelo:</strong> ${item.modelo}</p>
              <p><strong>Marca:</strong> ${item.marca}</p>
              <p><strong>Tela:</strong> ${item.tela}</p>
              <p><strong>Memória:</strong> ${item.memoria}</p>
              <p><strong>Câmera:</strong> ${item.camera}</p>
              <p><strong>Bateria:</strong> ${item.bateria}</p>
              <p><strong>Preço da Tela:</strong> ${item.precoTela}</p>
              <p><strong>Preço da Bateria:</strong> ${item.precoBateria}</p>
              <p><strong>Preço da Placa:</strong> ${item.precoPlaca}</p>
            </div>
          `;
        });
      })
      .catch(err => {
        document.getElementById("resultado").innerHTML = "<p>Erro ao buscar dados.</p>";
        console.error(err);
      });
  }
  