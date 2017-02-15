echo "Starting run"
start CALL doh-config.bat 
SLEEP 30
start CALL doh-discovery.bat 
SLEEP 30
start CALL doh-admin.bat 
start CALL doh-tracing.bat 
start CALL doh-gateway.bat 
start CALL doh-api.bat 
start CALL doh-api-lag.bat
echo "Finished run"
SLEEP 30