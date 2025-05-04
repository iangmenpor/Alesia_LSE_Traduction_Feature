# Alesia - Traductor de Lengua de Signos Española

![Screenshot_20250503_203436_Alesia-LSE-Traduction-feature](https://github.com/user-attachments/assets/d2f9fd4e-f272-466c-8e9d-8c4cc3641058)

## 📱 Acerca del proyecto

Alesia es una aplicación móvil que utiliza tecnologías de visión artificial para traducir la Lengua de Signos Española (LSE) a texto y audio en tiempo real. El nombre es un acrónimo de "Asistente para la Lengua de Signos con IA".

La aplicación está diseñada para facilitar la comunicación entre personas signantes y no signantes, contribuyendo a derribar barreras comunicativas en diversos ámbitos de la vida cotidiana.

### ✨ Características principales

- **Reconocimiento en tiempo real** de señas del abecedario dactilológico
- **Detección** de manos.
- **Traducción a texto** de las señas reconocidas
- **Interfaz intuitiva** diseñada con principios de accesibilidad
- **Funcionamiento offline** sin necesidad de conexión a internet

## 🛠️ Tecnologías utilizadas

- **MediaPipe**: Framework de Google para soluciones de visión artificial
- **TensorFlow Lite**: Para la ejecución eficiente de modelos de ML en dispositivos móviles
- **Android Studio**: Entorno de desarrollo integrado
- **Java/Kotlin**: Lenguajes de programación para el desarrollo de la aplicación
- **Google Colab**: Para el entrenamiento de modelos personalizados

## 🧠 Entrenamiento
- Link a proyecto de Google Colabs: [https://colab.research.google.com/drive/1Yz0EGTKK17NwNYwfFeQ_VxqvWxumcXNL?usp=sharing](https://colab.research.google.com/drive/1Yz0EGTKK17NwNYwfFeQ_VxqvWxumcXNL?usp=sharing.)
## 🚀 Instalación

### Requisitos previos
- Android 7.0 (API nivel 24) o superior
- 100MB de espacio de almacenamiento
- Cámara funcional

### Instalación desde archivo APK
1. Descarga el archivo APK desde la sección de [Releases](https://github.com/iangmenpor/Alesia_LSE_Traduction_Feature/releases)
2. Habilita la instalación de aplicaciones de fuentes desconocidas en tu dispositivo
3. Abre el archivo APK y sigue las instrucciones de instalación

### Compilación desde el código fuente
1. Clona este repositorio:
```bash
git clone https://github.com/iangmenpor/Alesia_LSE_Traduction_Feature.git
```
2. Abre el proyecto en Android Studio
3. Sincroniza el proyecto con Gradle
4. Compila y ejecuta la aplicación en tu dispositivo

## 📖 Uso básico

1. **Iniciar la aplicación**: Abre Alesia desde el menú de aplicaciones
2. **Conceder permisos**: Permite el acceso a la cámara cuando se solicite
3. **Realizar señas**: Posiciona tu mano en el cuadro de la cámara y realiza señas del abecedario dactilológico
4. **Ver resultados**: La aplicación mostrará el texto correspondiente a las señas reconocidas
5. **Formar palabras**: Las letras reconocidas se irán acumulando para formar palabras
6. **Borrar**: Utiliza el botón de borrar para reiniciar el texto acumulado
7. **Reproducir**: Se reproducirá en Audio la palabra formada 

## 🧠 Detalles técnicos

### Arquitectura

La aplicación está estructurada en tres módulos principales:
- **Módulo de captura**: Gestiona la entrada de video y preprocesamiento
- **Módulo de detección**: Identifica landmarks en manos, rostro y cuerpo
- **Módulo de reconocimiento**: Clasifica las configuraciones manuales detectadas

### Modelo de reconocimiento

- Entrenado específicamente para el abecedario dactilológico español
- Precision de 82.58% en el conjunto de prueba independiente
- Optimizado para ejecución en tiempo real con baja latencia

### Rendimiento

| Tipo de dispositivo | FPS | Latencia | Consumo de batería |
|---------------------|-----|----------|-------------------|
| Gama baja           | 5-10| 200-400ms| ~15-20% por hora  |
| Gama media          | 15-20| 100-200ms| ~10-15% por hora |
| Gama alta           | 25-30| 50-100ms | ~5-10% por hora  |

## 🔄 Estado actual y limitaciones

La versión actual (1.0.0) presenta las siguientes limitaciones:
- Reconoce 19 letras estáticas del abecedario dactilológico español
- No reconoce aún las 11 letras dinámicas (CH, G, H, J, LL, Ñ, RR, V, W, X, Y, Z)
- No incluye reconocimiento contextual para mejorar la precisión
- El rendimiento puede verse afectado por condiciones de iluminación deficiente

## 🔮 Desarrollo futuro

- Implementación del reconocimiento de letras dinámicas
- Expansión a vocabulario general de LSE
- Mejora de precisión mediante análisis contextual
- Integración de síntesis de voz para salida de audio
- Soporte para dialectos regionales de LSE

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir al proyecto:

1. Haz un fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/amazing-feature`)
3. Realiza tus cambios y haz commit (`git commit -m 'Add some amazing feature'`)
4. Push a la rama (`git push origin feature/amazing-feature`)
5. Abre un Pull Request

## 📞 Contacto

Ian Gabriel Mendoza Portillo - [ian.mendoza.dev@gmail.com](mailto:ian.mendoza.dev@gmail.com)

Enlace del proyecto: [https://github.com/iangmenpor/Alesia_LSE_Traduction_Feature](https://github.com/iangmenpor/Alesia_LSE_Traduction_Feature)

## 🙏 Agradecimientos

- Intérpretes profesionales de LSE por su asesoramiento
- Fundación CNSE por los recursos sobre Lengua de Signos Española
- Google MediaPipe Team por el framework y la documentación
- IES Alonso de Madrigal por el apoyo durante el desarrollo del proyecto

---

⌨️ con ❤️ por [Ian Gabriel Mendoza Portillo](https://github.com/iangmenpor)
