# registry2.py
services = {
    "CalculatorService": {
        "multiply": "http://localhost:5000/multiply",
        "divide": "http://localhost:5000/divide"
    }
}

def get_service_url(service_name, operation):
    return services.get(service_name, {}).get(operation), "Registry2"
