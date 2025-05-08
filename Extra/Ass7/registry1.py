# registry1.py
services = {
    "CalculatorService": {
        "add": "http://localhost:5000/add",
        "subtract": "http://localhost:5000/subtract"
    }
}

def get_service_url(service_name, operation):
    return services.get(service_name, {}).get(operation), "Registry1"
