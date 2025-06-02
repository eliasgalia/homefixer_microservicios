INSERT INTO notificaciones (id_usuario, titulo, mensaje, tipo, leida, fecha_envio, canal)
VALUES 
(10, 'Nuevo servicio disponible', 'Tienes una nueva solicitud en tu zona.', 'SOLICITUD', false, NOW(), 'EMAIL'),
(10, 'Pago recibido', 'Has recibido un nuevo pago.', 'PAGO', false, NOW(), 'PUSH');
