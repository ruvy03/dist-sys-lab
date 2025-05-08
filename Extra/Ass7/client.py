# client.py
import requests
import registry1
import registry2

def call_service(service_name, operation, a, b):
    # Select registry based on operation
    if operation in ['add', 'subtract']:
        url, registry_name = registry1.get_service_url(service_name, operation)
    elif operation in ['multiply', 'divide']:
        url, registry_name = registry2.get_service_url(service_name, operation)
    else:
        print("[ERROR] Unsupported operation.")
        return

    if not url:
        print(f"[{registry_name}] Operation '{operation}' not found in service registry.")
        return

    print(f"[{registry_name}] Resolving '{operation}' at: {url}")
    try:
        response = requests.get(url, params={'a': a, 'b': b})
        data = response.json()
        if response.status_code != 200:
            print(f"[{registry_name}] Error: {data.get('error')}")
        else:
            print(f"[{registry_name}] {operation.capitalize()} Result: {data['result']}")
    except Exception as e:
        print(f"[ERROR] Failed to call service: {e}")

if __name__ == "__main__":
    operation = input("Enter operation (add, subtract, multiply, divide): ").strip().lower()
    try:
        a = float(input("Enter first number: "))
        b = float(input("Enter second number: "))
        call_service("CalculatorService", operation, a, b)
    except ValueError:
        print("[ERROR] Invalid input. Please enter numbers.")
